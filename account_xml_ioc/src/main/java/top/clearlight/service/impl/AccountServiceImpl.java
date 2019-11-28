package top.clearlight.service.impl;

import top.clearlight.dao.AccountDao;
import top.clearlight.domain.Account;
import top.clearlight.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return null;
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(Integer accountId) {

    }
}
