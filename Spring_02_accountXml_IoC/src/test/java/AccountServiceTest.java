import domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.impl.AccountServiceImpl;

public class AccountServiceTest {
    // private AccountService accountService = new AccountServiceImpl();

    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = ac.getBean(AccountService.class);
    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setNumber("123456");
        account.setBalance(9000f);
        accountService.saveAccount(account);
    }
}
