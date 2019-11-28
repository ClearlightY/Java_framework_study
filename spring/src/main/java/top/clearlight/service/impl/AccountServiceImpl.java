package top.clearlight.service.impl;

import top.clearlight.dao.AccountDao;
import top.clearlight.dao.impl.AccountDaoImpl;
import top.clearlight.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    /**
     业务层调用持久层
     IoC(控制反转)
     将控制权交给工厂,来帮我们创建对象. 带来的好处就是 降低了程序间的依赖关系, 也叫削减计算机的耦合
      */
    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}

