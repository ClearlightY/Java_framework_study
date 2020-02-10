package dao;

import domain.Account;

public interface AccountDao {
    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer aid);

    Account findAccountByAid(Integer aid);
}
