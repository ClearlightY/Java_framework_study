import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.clearlight.dao.UserDao;
import top.clearlight.domain.User;

import java.io.InputStream;

public class MyBatisDemo {
    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setUsername("甜甜");

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(in);
        // 创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        // 执行操作: insert(String, Object): String:配置文件namespace+id. Object:要保存的数据
        sqlSession.insert("top.clearlight.saveUser", user);
        // 提交事务. MyBatis中事务默认不是自动的
        sqlSession.commit();
        // 释放sqlSession占用的资源
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        User user = new User();
        user.setUsername("甜甜甜");

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(in);
        // 创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();

        // getMapper只需要指定接口类型, MyBatis自动产生实现该类的字节码并返回对应的对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.saveUser(user);

        // 提交事务, MyBatis中事务默认不是自动的
        sqlSession.commit();
        // 释放sqlSession占用的资源
        sqlSession.close();
    }
}
