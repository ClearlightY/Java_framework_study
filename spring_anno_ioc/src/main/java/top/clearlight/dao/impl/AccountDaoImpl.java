package top.clearlight.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.clearlight.dao.AccountDao;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
