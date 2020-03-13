package top.clearlight.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.clearlight.dao.UserDao;
import top.clearlight.domain.QueryVo;
import top.clearlight.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试MyBatis的CRUD操作
 *
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/11 17:05
 */
public class MyBatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        // 1. 读取配置文件, 生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3. 获取SqlSession对象
        sqlSession = factory.openSession();
        // 4. 获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception {
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        in.close();

    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {

        // 5. 执行查询所有方法
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void saveUserTest() {
        User user = new User();
        // user.setUsername("mybatis saveUser");
        user.setUserName("mybatis last insert_id");
        user.setUserAddress("Ch");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前: " + user);
        // 执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后: " + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void updateUserTest() {
        User user = new User();
        user.setUserId(2);
        user.setUserName("mybatis updateUser");
        user.setUserAddress("Zh");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        // 执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void deleteUserTest() {
        userDao.deleteUser(1);
    }

    /**
     * 测试根据查询用户
     */
    @Test
    public void testFindById() {

        // 5. 执行查询所有方法
        User user = userDao.findById(2);

        System.out.println(user);
    }

    /**
     * 根据名称模糊查询用户信息
     */
    @Test
    public void testFindByName() {
        // 根据名称模糊查询用户
        List<User> users = userDao.findByName("%batis%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询用户总数
     */
    @Test
    public void testFindTotal() {
        int num = userDao.findTotal();
        System.out.println(num);
    }

    /**
     * 根据queryVo的条件查询用户
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%batis%");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}