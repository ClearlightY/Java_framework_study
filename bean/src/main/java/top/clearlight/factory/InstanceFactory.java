package top.clearlight.factory;

import top.clearlight.service.AccountService;
import top.clearlight.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public /*static*/ AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
