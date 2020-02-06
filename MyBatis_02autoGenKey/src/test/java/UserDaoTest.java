import org.junit.Test;
import top.clearlight.dao.UserDao;
import top.clearlight.domain.User;

import java.util.*;

public class UserDaoTest extends BaseTester {
    @Test
    public void testSaveUser1() {
        User user = new User();
        user.setUsername("小明");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.saveUser1(user);
        // 观察UID的取值
        System.out.println(user);
    }

    @Test
    public void testSaveUser2() {
        User user = new User();
        user.setUsername("小红");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.saveUser1(user);
        // 观察UID的取值
        System.out.println(user);
    }

    @Test
    public void findUsers() {
        User condition = new User();
        // condition.setUid(1);
        // condition.setUsername("aaa");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUsers(condition);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void updateUser() {
        User user = new User();
        // user.setUid(1);
        // user.setUsername("ABC");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUser(user);
    }

    @Test
    public void saveUser3() {
        User user = new User();
        user.setUsername("CL");
        user.setGender("male");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.saveUser3(user);
        System.out.println(user);
    }

    @Test
    public void findUsers1() {
        Integer[] uids = {1, 2, 3, 4};
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUsers1(uids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUsers2() {
        List<Integer> uids = new ArrayList<Integer>();
        uids.add(1);
        uids.add(2);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUsers2(uids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUsers3() {
        Set<Integer> uids = new HashSet<Integer>();
        uids.add(1);
        uids.add(2);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUsers3(uids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUsers4() {
        Map<String, Integer> uids = new HashMap<String, Integer>();
        uids.put("a", 1);
        uids.put("b", 2);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUsers4(uids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUsers5() {
        User condition = new User();
        condition.setUid(1);
        // condition.setUsername("bbb");
        // condition.setGender("male");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUsers5(condition);
        for (User user : users) {
            System.out.println(user);
        }
    }
}