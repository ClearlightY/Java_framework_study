import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.clearlight.pojo.Books;
import top.clearlight.service.BookService;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/6 15:00
 */
public class Test1 {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        for (Books book :
                bookServiceImpl.queryAllBook()) {
            System.out.println(book);
        }
    }
}
