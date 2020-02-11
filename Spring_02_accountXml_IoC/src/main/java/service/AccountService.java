package service;

import domain.Account;

public interface AccountService {
    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer aid);

    Account findAccountByAid(Integer aid);
}
