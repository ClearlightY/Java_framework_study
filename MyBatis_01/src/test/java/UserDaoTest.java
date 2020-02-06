import org.junit.Test;
import top.clearlight.dao.UserDao;
import top.clearlight.domain.User;
import top.clearlight.vo.UserVO;

import java.util.List;

public class UserDaoTest extends BaseTester {
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("特别甜");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.saveUser(user);
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUid(1);
        user.setUsername("炒鸡甜");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void testDelUser() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.delUser(3);
    }

    @Test
    public void testFindAllUser1() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> allUsers1 = userDao.findAllUsers1();
        System.out.println(allUsers1);
    }

    @Test
    public void testFindAllUser2() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> allUser1 = userDao.findAllUsers2();
        System.out.println(allUser1);
    }

    @Test
    public void testFind1() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByUid(1);
        System.out.println(user);
    }

    @Test
    public void testFind2() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByUidUsername(1, "炒鸡甜");
        System.out.println(user);
    }

    @Test
    public void testFind3() {
        UserVO vo = new UserVO();
        vo.setUid(1);
        vo.setUsername("炒鸡甜");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByUidUsername1(vo);
        System.out.println(user);
    }

    @Test
    public void testFind4() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUserByUsername1("%甜%");
        System.out.println(users);
    }

    @Test
    public void testFind5() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUserByUsername2("甜");
        System.out.println(users);
    }

    @Test
    public void test6() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUserByUsername3("甜");
        System.out.println(users);
    }
}
