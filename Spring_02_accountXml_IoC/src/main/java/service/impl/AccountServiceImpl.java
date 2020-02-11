package service.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import domain.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
