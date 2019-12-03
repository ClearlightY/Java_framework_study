package top.clearlight;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.clearlight.domain.Account;
import top.clearlight.service.AccountService;

import java.util.List;

/**
 * 使用Junit单元测试: 测试我们的配置
 * Spring整合Junit的配置
 *  1. 导入Spring整合Junit的jar包(坐标)
 *  2. 使用Junit提供的一个注解把原有的main方法替换了, 替换成Spring提供的
 *      @Runwith
 *  3. 告知Spring的运行期, Spring的IoC创建是基于xml还是注解的, 并且说明位置
 * @ContextConfiguratiion
 *  locations: 指定xml文件的位置, 加上classpath关键字, 表示在类路径下
 *  classes : 指定注解类所在位置
 *
 *  当我们使用Spring 5.x 版本的时候, 要求Junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public void testFindAll() {
        // 1. 获取容器
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        // ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2. 得到业务层对象
        // AccountService as = ac.getBean("accountService", AccountService.class);
        // 3. 执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100f);
    }

    @Test
    public void testEat() {
        System.out.println("eat dinner");
    }
}
