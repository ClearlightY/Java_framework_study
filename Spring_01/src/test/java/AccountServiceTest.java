import domain.Account;
import org.junit.Test;
import service.AccountService;
import service.impl.AccountServiceImpl;

public class AccountServiceTest {
    private AccountService accountService = new AccountServiceImpl();

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setNumber("123456");
        account.setBalance(9000f);
        accountService.saveAccount(account);
    }
}
