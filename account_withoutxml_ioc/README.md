## Junit问题分析
1. 应用程序的入口

    main方法
    
2. Junit单元测试中, 没有main方法也能执行

    Junit集成了一个main方法
    该方法就会判断当前测试类中哪些方法有@Test注解
    Junit就让有Test注解的方法执行
    
3. Junit不会管我们是否采用Spring框架

    在执行测试方法时, Junit根本不知道我们是不是使用了Spring框架,
    所以也就不会为我们读取配置文件/配置类创建Spring核心容器
    
4. 由以上三点可知
    当测试方法执行时, 没有IoC容器, 就算写了Autowired注解, 也无法实现注入.