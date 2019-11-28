package top.clearlight.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.clearlight.service.AccountService;
import top.clearlight.service.impl.AccountServiceImpl;
import top.clearlight.service.impl.AccountServiceImpl2;

/**
 * 模拟一个表现层, 用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IoC核心容器, 并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {

        // 1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountService as1 = (AccountService) ac.getBean("accountService");
        System.out.println(as == as1);

        AccountServiceImpl as2 = (AccountServiceImpl) ac.getBean("accountService1");
        System.out.println(as2.getName() + ":" + as2.getAge() + ":" + as2.getBirthday());

        AccountServiceImpl as3 = (AccountServiceImpl) ac.getBean("accountService2");
        System.out.println(as3.getName() + ":" + as3.getAge() + ":" + as3.getBirthday());

        AccountServiceImpl2 as4 = (AccountServiceImpl2) ac.getBean("accountService3");
        as4.saveAccount();
    }
}
