import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.clearlight.dao.AccountDao;
import top.clearlight.domain.Account;

import java.util.List;

public class AccountDaoTest extends BaseTester {
    @Test
    public void test() {
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAllAccountsWithUser();
        for (Account account : accounts) {
            System.out.println("----------------");
            System.out.println("Account:" + account);
            System.out.println("User:" + account.getUser());
        }
    }
}
