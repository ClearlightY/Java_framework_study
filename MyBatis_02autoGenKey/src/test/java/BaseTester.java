import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import top.clearlight.util.MyBatisUtil;

public class BaseTester {
    protected SqlSession sqlSession;

    // 会在每个测试方法前执行
    @Before
    public void openSession() {
        sqlSession = MyBatisUtil.openSession();
    }

    // 会在每个测试方法后执行
    @After
    public void closeSession() {
        sqlSession.commit();
        sqlSession.close();
    }

}
