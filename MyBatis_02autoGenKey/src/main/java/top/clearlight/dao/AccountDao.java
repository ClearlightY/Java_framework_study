package top.clearlight.dao;

import top.clearlight.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccountsWithUser();
}
