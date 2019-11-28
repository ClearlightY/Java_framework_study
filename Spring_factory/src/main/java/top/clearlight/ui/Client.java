package top.clearlight.ui;

import top.clearlight.factory.BeanFactory;
import top.clearlight.service.AccountService;
import top.clearlight.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层, 用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            as.saveAccount();
            System.out.println(as);
        }
    }
}
