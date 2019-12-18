# Java_framework_study
主要包括笔记,以及配置,学习ssm框架

# 一. 程序的耦合

---

1. 耦合 : 程序间的依赖关系

   包括 :

   - 类之间的依赖
   - 方法间的依赖

2. 解耦 : 降低程序间的依赖关系

3. 实际开发 : 应该做到 `编译器不依赖, 运行期才依赖`

4. 解耦的思路 : 

   1. 使用反射的方式创建对象, 而避免使用new关键字
   2. 通过读取配置文件来获取要创建的对象全限定类名

![1574769518366](https://s2.ax1x.com/2019/12/01/QmsEs1.png)

IoC(控制翻转) : Inversion of Control, 把创建对象的权利交给框架, 是框架的重要特征, 并非面向对象编程的专用术语. 它包括依赖注入(Dependency Injection, 简称DI) 和 依赖查找(Dependency Lookup)

Ioc的作用 : `削减计算机程序的耦合(解除我们代码中的依赖关系).` 

​	

```java
/**
     业务层调用持久层
     IoC(控制反转)
     将控制权交给工厂,来帮我们创建对象. 带来的好处就是 降低了程序间的依赖关系, 也叫削减计算机的耦合
      */
    // private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
```



# 二. 使用Spring的IOC解决程序的耦合

---

## 2.1 xml方式

bean.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--把对象的创建交给spring来管理-->
    <bean id="accountService" class="top.clearlight.service.impl.AccountServiceImpl"></bean>
    <bean id="accountDao" class="top.clearlight.dao.impl.AccountDaoImpl"></bean>
</beans>
```



获取Spring的IoC核心容器, 并根据id获取对象



**`ApplicationContext`的三个常用实现类 :**

- `ClassPathXmlApplicationContext` : 它可以加载类路径下的配置文件, 要求配置文件必须在类路径下. 不在的话, 加载不了
- `FileSystemXMLApplicationContext` : 它可以加载磁盘任意路径下的配置文件(必须有访问权限)
- `AnnotationConfigApplicationContext`  : 它是用于读取注解创建容器的



核心容器的两个接口 :

- `ApplicationContext` : (单例对象使用)(开发使用更多)

  它在构建核心容器时, 创建对象采取的策略是采用立即加载的方式. 也就是说, 只要一读取完配置文件马上就创建配置文件中配置的对象.

  ```java
  		// 1. 获取核心容器对象
          ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
          // applicationcontext ac = new filesystemxmlapplicationcontext("c:\\users\\87052\\desktop\\bean.xml");
  
          // 2. 根据id获取Bean对象
          AccountService as = (AccountService) ac.getBean("accountService");
          AccountDao ad = ac.getBean("accountDao", AccountDao.class);
  ```

  

- `BeanFactory` : (多例对象适用)

  它在构件核心容器时, 创建对象采取的策略是采用延迟加载的方式. 也就是说, 什么时候根据id获取对象了, 什么时候才真正的创建对象.

  ```java
   		Resource resource = new ClassPathResource("bean.xml");
          BeanFactory factory = new XmlBeanFactory(resource);
          AccountService as1 = (AccountService) 					factory.getBean("accountService");
  ```

  

spring对bean的管理细节    

1. 创建bean的三种方式    

   1. 使用默认构造函数创建

      在spring的配置文件中使用bean标签, 配以id和class属性之后, 且没有其他属性和标签时, 采用的就是默认构造函数创建bean对象, 此时如果类中没有默认构造函数, 则对象无法创建.

      ```java
      <!-- 使用默认构造函数创建对象 -->
      <bean id="accountService" class="top.clearlight.service.impl.AccountServiceImpl"></bean>
      ```

      

   2. 使用普通工厂中的方法创建对象(使用某个类中的方法创建对象, 并存入spring容器)

      ```java
      /**
      *模拟一个工厂类(该类可能存在于jar包中, 我们无法通过修改源码的方式来提供默认构造函数)
      */
      public class InstanceFactory {
          public AccountService getAccountService() {
              return new AccountServiceImpl();
          }
      }
      ```

      

      ```java
      <bean id="instanceFactory" class="top.clearlight.factory.InstanceFactory"></bean>
      <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
      ```

      

   3. 使用工厂中的静态方法创建对象(使用某个类中的静态方法创建对象, 并存入spring容器)

      ```java
      /**
      * 模拟一个工厂类,其中创建对象的方法是静态的
      */
      public class StaticFactory {
          public static AccountService getAccountService() {
              return new AccountServiceImpl();
          }
      }
      ```

      

      ```java
      <bean id="accountService" class="top.clearlight.factory.StaticFactory" factory-method="getAccountService"></bean>
      ```

       

      Tips : 第二种和第三种的xml配置方式不同的原因和真实调用方法的不同是类似的. 普通方法需要通过new该类后再去调用类中普通方法, 而静态方法(第三种)可以直接通过类名来直接调用.

   

2. bean对象的作用范围    

   bean标签的scope属性 :

   - 作用 : 用于指定bean的作用范围
   - 取值 : 常用的就是单例的和多例的
     1. singleton : 单例的(默认值)
     2. prototype : 多例的
     3. request : 作用于web应用的请求范围
     4. session : 作用于web应用的会话范围
     5. global-session : 作用于集群环境的会话范围(全局会话范围), 当不是集群环境时, 它就是session
   
        ![1574848444772](https://s2.ax1x.com/2019/12/01/QmsQRH.png)

3. bean对象的生命周期

   - 单例对象 (立即)
     - 出生 : 当容器创建时对象出生
     - 活着 : 只要容器还在, 对象一直活着
     - 死亡 : 容器销毁, 对象消亡
     - 总结 : 单例对象的生命周期和容器相同
   - 多例对象 (延迟)
     - 出生 : 当我们使用对象时spring框架为我们创建
     - 活着 : 对象只要是在使用过程中就一直活着
     - 死亡 :  当对象长时间不用, 且没有别的对象引用时, 由Java的垃圾回收器回收

4. Spring的依赖注入

   依赖注入 : Dependency Injection

   IoC的作用 : 降低程序间的耦合 (依赖关系)

   依赖关系的管理 : 都交给Spring的维护

   在当前类需要用到其他类的对象, 由Spring为我们提供, 我们只需要在配置文件中说明

   `依赖关系的维护 : 就称之为依赖注入`

5. 依赖注入 

   能注入的数据 : 

   - 基本类型和String
   - 其他bean类型(在配置文件中或者注解配置过的bean)
   - 复杂类型/集合类型
   
   注入的方式 :
   
   1. 使用构造函数提供
   
      使用的标签 : `constructor-arg`
   
      标签出现的位置 : bean标签的内部
   
      标签中的属性 : 
   
      - type : 用于指定要注入的数据的数据类型, 该数据类型也是构造函数中某个或某些参数的类型
      - index : 用于指定要注入的数据给构造函数中指定索引位置的参数赋值. 索引的位置是从0开始
      - name : 用于指定给构造函数中指定名称的参数赋值 
      - ---------以上三个用于指定给构造参数中哪个参数赋值----------
      - value : 用于提供基本类型和String类型的数据
      - ref : 用于指定其他的bean类型数据. 它指的就是在Spring的Ioc核心容器中出现过的bean对象 (引用关联的bean对象)
   
      ```xml
      <bean id="accountService" class="top.clearlight.service.impl.AccountServiceImpl">
      	<constructor-arg name="name" value="jack"></constructor-arg>
          <constructor-arg name="age" value="18"></constructor-arg>
          <constructor-arg name="birthday" ref="now"></constructor-arg>
      </bean>
      
      <!-- 配置一个日期对象 -->
      <bean id="now" class="java.util.Date"></bean>
      ```
   
      优势 : 在获取bean对象时, 注入数据是必须的操作, 否则对象无法创建成功.
   
      弊端 : 改变了bean对象的实例化方式, 使我们在创建对象时, 如果用不到这些数据, 也必须提供.
   
      
   
   2. 使用set方法提供 (常用)
   
      首先在需要创建对象的类中为每个字段生成set方法!
   
      使用的标签 : `property`
   
      出现的位置 : bean标签的内部
   
      标签的属性 : 
   
      - name : 用于指定注入时所调用的set方法名称
      - value : 用于提供基本类型和String类型的数据
      - ref : 用于指定其他的bean类型数据. 它指的就是在Spring的IoC核心容器中出现过的bean对象
   
      ```xml
       <bean id="accountService1" class="top.clearlight.service.impl.AccountServiceImpl">
              <property name="name" value="Mike"/>
              <property name="age" value="17"/>
              <property name="birthday" ref="now"/>
          </bean>
      
          <bean id="now" class="java.util.Date"/>
      ```
   
      优势 : 创建对象时没有明确的限制, 可以直接使用默认构造函数
   
      弊端 : 如果有某个成员必须有值, 则获取对象是有可能set方法没有执行
   
   3.   复杂类型/集合类型通过set方法依赖注入
   
      首先创建集合类型变量
   
      ```java
      	private String[] myStrs;
          private List<String> myList;
          private Set<String> mySet;
          private Map<String, String> myMap;
          private Properties myPro;
      ```
   
      并生成对应的set方法,开始通过bean.xml依赖注入
   
      ```xml
          <!--复杂类型的注入/集合类型的注入-->
          <bean id="accountService3" class="top.clearlight.service.impl.AccountServiceImpl2">
              <property name="myStrs">
                  <array>
                      <value>AAA</value>
                      <value>BBB</value>
                      <value>CCC</value>
                  </array>
              </property>
      
              <property name="myList">
                  <list>
                      <value>AAA</value>
                      <value>BBB</value>
                      <value>CCC</value>
                  </list>
              </property>
      
              <property name="mySet">
                  <set>
                      <value>AAA</value>
                      <value>BBB</value>
                      <value>CCC</value>
                  </set>
              </property>
      
              <property name="myMap">
                  <map>
                      <entry key="jack" value="18"/>
                      <entry key="Marry" value="16"/>
                      <entry key="Bob">
                          <value>19</value>
                      </entry>
                  </map>
              </property>
      
              <property name="myPro">
                  <props>
                      <prop key="A">AAA</prop>
                      <prop key="B">BBB</prop>
                  </props>
              </property>
          </bean>
      ```
   
      用于给List结构集合注入的标签 : list array set
   
      用于给Map结构集合注入的标签 : map props
   
      结构相同, 标签可以互换 
   
   4. 使用注解提供
   
   ​		





## 2.2注解方式



曾经XML的配置 :

```xml
 <bean id="accountService" class="top.clearlight.service.impl.AccountServiceImpl" scope="" init-method="" destory-method="">
	<property name="" value="" / ref=""></property>
</bean>
```

- 用于创建对象的

  > 它们的作用就和在XML配置文件中编写一个`<bean>`标签实现的功能是一样的

  ​	`Component` :

  ​		作用 : 用于把当前类对象存入spring容器中

  ​		属性 : value : 用于指定bean的id. 当不写时, 它的默认值是当前类名,且首字母改小写

  ​	-----以下三个注解它们的作用和属性与Component是一模一样.----

  ​	它们三个是Spring框架为我们提供明确的三层使用的注解, 使我们的三层对象更加清晰

  ​	`Controller` : 一般用在表现层

  ​	`Service` : 一般用在业务层

  ​	`Repository` : 一般用在持久层

- 用于注入数据的 

  > 它们的作用就和XML配置文件中的bean标签中写一个`<property>`标签的作用是一样的

  - `Autowired` : 

    - 作用 : 自动按照类型注入. 只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配, 就可以注入成功.

      如果IoC容器中没有任何bean的类型和要注入的变量类型匹配, 则报错.

      如果IoC容器中有多个类型匹配时 :

    - 出现位置 : 可以是变量上, 也可以是方法上

    - 细节 : 在使用注解注入时, set方法就不是必须的了.

  - `Qualifier` :

    - 作用 : 在按照类中注入的基础之上在按照名称注入. 它再给类成员注入时不能单独使用. ...
    - 属性 : value 用于指定注入bean的id

  - `Resource` : 

    - 作用 : 直接按照bean的id注入, 它可以独立使用
    - 属性 : name 用于指定bean的id

  - ----- 以上三个注入都只能注入其他bean类型的数据, 而基本类型和String类型无法使用上述注解实现. **另外, 集合类型的注入只能通过xml来实现**

  - `Value` : 

    - 作用 : 用于注入基本类型和String类型的数据

    - 属性 :  value 用于指定数据的值. 它可以使用Spring中的SpEL(也就是Spring的el表达式)

      SpEL的写法 : ${表达式}

- 用于改变作用范围的

  > 它们的作用就和在bean标签中使用scope属性实现的功能是一样的

  - `Scope` :
    - 作用 : 用于指定bean的作用范围
    - 属性 : value 指定范围的取值. 常用取值 : singleton prototype

  

- 和生命周期相关

  > 它们的作用就和bean标签中使用init-method和destory-method的作用是一样的
  
  - `PreDestory` :
    - 作用 : 用于指定销毁方法
  - `PostConstruct` :
    - 作用 : 用于指定初始化方法

# 三. 动态代理

特点 : 字节码随用随创建, 随用随加载



作用 : 不修改源码的基础上对方法增强



分类 : 

1. 基于接口的动态代理	
2. 2. 基于子类的动态代理



基于接口的的动态代理 : 

​	涉及的类 : Proxy

​	提供者 : JDK官方



如何创建代理对象 ; 

​	使用Proxy类中的`newProxyInstance`方法



创建代理对象的要求 :

​	被代理类最少实现一个接口, 如果没有则不能使用



`newProxyInstance`方法的参数 :

- ClassLoader : 类加载器

  它是用于加载代理对象字节码的. 和被代理对象使用相同的类加载器. 固定写法.

- Class[] :

  它是用于让代理对象和被代理对象有相同的方法. 固定写法.

- InvocationHandler :

  它是让我们写如何代理. 我们一般都是写一个该接口的实现类, 通常情况下都是匿名内部类, 但不是必须的



# 4. AOP(面向切面编程)

Aspect Oriented Programming



作用:

​	在程序运行期间, 不修改源码对已有方法进行增强



优势:

- 减少重复代码
- 提高开发效率
- 维护方便



关于代理的选择 :

​	在Spring中, 框架会根据目标类是否实现了接口来决定采用哪种动态代理的方式



## 4.1 AOP相关术语

连接点(`Joinpoint`) : 业务层接口中所有的方法

连接业务和增强方法的点



切入点(`Pointcut`) : 被增强的方法



Advice(通知/增强): 拦截到连接点之后所要做的事情就是通知(提供了公共代码的类)

![1575796804760](/home/lixiaoyi/.config/Typora/typora-user-images/1575796804760.png)



Target(目标对象) : 代理的目标对象(业务层service)



Weaving(织入) : 原有的Service没法实现事物的支持, 然后使用动态代理技术创建了一个新的对象, 返回了一个代理对象. 返回代理对象的过程中, 其中加入了事物的支持, 加入事物支持的过程, 叫织入.



Proxy(代理) : 一个类被AOP织入增强后, 就产生一个结果代理类`(AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {})`



Aspect(切面) : 是切入点和通知(引介) 的结合.

建立切入点方法和通知方法执行调用的对应关系就是切面



Spring中AOP运行阶段(Spring框架完成的)

Spring框架监控切入点方法的执行. 一旦监控到切入点方法被运行, 使用代理机制, 动态创建目标对象的代理对象, 根据通知类别, 在代理对象的对应位置, 将通知对应的功能织入, 完成完整的代码逻辑运行.



## 4.2 Spring中基于XML的AOP配置

1. 把通知Bean也交给Spring来管理

2. 使用aop:config标签表名开始AOP的配置

3. 使用aop:aspect标签表名配置切面

   - id属性: 是给切面提供一个唯一标识
   - ref属性: 是给指定通知类bean的id

4. 在aop:aspect标签的内部使用对应标签来配置通知的类型

   我们现在示例是让printLog方法在切入点方法执行之前: 所以是前置通知

   aop:before: 表示配置前置通知

   ​	method属性: 用于指定Logger类中哪个方法是前置通知

   ​	pointcut属性: 用于指定切入点表达式, 该表达式的含义指的是对业务层中哪些方法增强

   ​	

   切入点表达式的写法:

   - 关键字: execution(表达式)
   
   - 表达式: 访问修饰符 返回值 包名.包名.包名...类名.方法名(参数列表)
   
   - 标准的表达式写法: 
   
     `public void top.clearlight.service.impl.AccountServiceImpl.saveAccount()`
   
   - 访问修饰符可以省略
   
     `void top.clearlight.service.impl.AccountServiceImpl.saveAccount()`
   
   - 返回值可以使用通配符, 表示任意返回值
   
     `* top.clearlight.service.impl.AccountServiceImpl.saveAccount()`
   
   - 包名可以使用通配符, 表示任意包. 但是有几级包, 就需要写几个*
   
     `* *.*.*.*.AccountServiceImpl.saveAccount()`
   
   - 包名可以使用..表示当前包及其子包
   
     `* *..AccountServiceImpl.saveAccount()`
   
   - 类名和方法名都可以使用*来实现通配
   
     `* *..*.*()`
   
   - 参数列表:
   
     可以直接写数据类型:
   
     - 基本数据类型直接写名称	int
     - 引用类型写包名.类名的方式    java.lang.String
   
     可以使用通配符表示任意类型, 但是必须有参数
   
     可以使用..表示有无参数均可, 有参数可以是任意类型
   
   - 全通配写法:
   
     `* *..*.*(..)`
     
   - 实际开发中切入点表达式的通常写法:
   
     切到业务层实现类下的所有方法:
     
     ​	`top.clearlight.service.impl.*.*(..)`
   
   ![1575947243455](/home/lixiaoyi/.config/Typora/typora-user-images/1575947243455.png)

5. 环绕通知

   问题: 当我们配置了环绕通知之后, 切入点方法没有执行, 而通知方法执行了.

   分析: 通过对比动态代理中的环绕通知代码, 发现动态代理的环绕通知有明确的切入点方法调用, 而我们的代码中没有.

   解决: Spring框架为我们提供了一个接口: ProceedingJoinPoint 该接口有一个方法proceed(), 此方法就相当于明确调用切入点方法.

   ​	该接口可以作为环绕通知的方法参数, 在程序执行时, Spring框架回味我们提供该接口的实现类供我们使用.

   Spring中的环绕通知：它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式.

   

   bean.xml的环绕通知配置:

   ```xml
   <aop:config>
       <!-- 配置切入点表达式 id属性用于指定表达式的唯一标识. expression属性用于指定表达式内容
   	此标签写在aop:aspect标签内部只能当前切面使用.
   	它还可以写在aop:aspect外面, 此时就变成了所有切面可用
   	-->
       <aop:pointcut id="pt1" expression="execution(* top.clearlight.service.impl.*.*(..))"></aop:pointcut>
   	<aop:aspect id="logAdvice" ref="logger">
           <!--配置环绕通知-->
           <aop:around method="aroundPrintLog" point-ref="pt1"></aop:around>
       </aop:aspect>
   </aop:config>
   ```

   

   

   增强类中的环绕通知方法:

   ```java
   public Object aroundPrintLog(ProceedingJoinPoint pjp) {
       Object rtValue = null;
       try {
           Object[] args = pjp.getArgs(); //得到方法执行所需的参数
           
           System.out.println("Logger类中的aroundPrintLog方法开始记录日志.. 前置");
           
           rtValue = pjp.proceed(args); // 明确调用业务层方法(切入点方法)
           
           System.out.println("Logger类中的aroundPrintLog方法开始记录日志.. 后置");
           
           return rtValue;
       } catch (Throwable e) {
           System.out.println("Logger类中的aroundPrintLog方法开始记录日志.. 异常");
           throw new RuntimeException(e);
       } finally {
           System.out.println("Logger类中的aroundPrintLog方法开始记录日志.. 最终");
       }
   }
   ```

   













Spring注解的xml配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">

        <!--把对象的创建交给spring来管理-->
        <context:component-scan base-package="top.clearlight"></context:component-scan>
</beans>
```



最简单的配置方式 : 存在于jar包中的类, 使用xml的形式

​									自己写的, 注解更方便 










