package top.clearlight.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.clearlight.dao.AccountDao;
import top.clearlight.service.AccountService;
import top.clearlight.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层, 用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IoC核心容器, 并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        // AccountService as = new AccountServiceImpl();
        // as.saveAccount();
        // System.out.println(as);

        // 1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // applicationcontext ac = new filesystemxmlapplicationcontext("c:\\users\\87052\\desktop\\bean.xml");
        // 2. 根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);

        // 第二种方式进行创建对象, 延时创建.
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as1 = (AccountService) factory.getBean("accountService");
        System.out.println(as1);
    }
}
