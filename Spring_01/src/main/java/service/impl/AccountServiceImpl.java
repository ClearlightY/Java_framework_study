package service.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import domain.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer aid) {
        accountDao.deleteAccount(aid);
    }

    public Account findAccountByAid(Integer aid) {
        return accountDao.findAccountByAid(aid);
    }
}
