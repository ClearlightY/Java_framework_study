package top.clearlight.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.clearlight.dao.AccountDao;
import top.clearlight.service.AccountService;

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

        System.out.println(as);

        AccountDao ad = (AccountDao) ac.getBean("accountDao");
        System.out.println(ad);
    }
}
