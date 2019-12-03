package top.clearlight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.clearlight.dao.AccountDao;
import top.clearlight.dao.impl.AccountDaoImpl;
import top.clearlight.domain.Account;
import top.clearlight.service.AccountService;
import top.clearlight.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * <p>
 * 事务控制应该都是在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    /**
     * 由于每次获取一个连接, 导致无法实现事务控制
     * @param sourceName    转出账户名称
     * @param targetName    转入账户名称
     * @param money         持有金额
     */
    public void transfer(String sourceName, String targetName, Float money) {
        // 2.1 根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2 根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 2.3 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 2.4 转入账户加钱
        target.setMoney(target.getMoney() + money);
        // 2.5 更新转出账户
        accountDao.updateAccount(source);

        int i = 1 / 0;

        // 2.6 更新转入账户
        accountDao.updateAccount(target);
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public AccountDaoImpl getAccountDao() {
        return (AccountDaoImpl) accountDao;
    }
}
