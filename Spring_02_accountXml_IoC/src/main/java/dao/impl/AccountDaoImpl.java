package dao.impl;

import dao.AccountDao;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    public void saveAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("参数错误");
        }
        try {
            qr.update("insert into account (number, balance) values(?, ?)",
                    account.getNumber(), account.getBalance());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("参数错误");
        }
        if (account.getAid() == null) {
            throw new IllegalArgumentException("参数错误");
        }
        try {
            qr.update("update account set number=?,balance=? where aid=?",
                    account.getNumber(), account.getBalance(), account.getAid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer aid) {
        try {
            qr.update("delete from account where aid=?", aid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByAid(Integer aid) {
        try {
            return qr.query("select * from account where aid=?",
                    new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
