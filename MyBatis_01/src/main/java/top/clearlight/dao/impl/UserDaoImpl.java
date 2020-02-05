package top.clearlight.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.clearlight.dao.UserDao;
import top.clearlight.domain.User;
import top.clearlight.vo.UserVO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public void saveUser(User user) {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = factory.openSession();
            sqlSession.insert("top.clearlight.saveUser", user);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件失败", e);
        }
    }

    public void updateUser(User user) {

    }

    public void delUser(Integer uid) {

    }

    public List<User> findAllUsers1() {
        return null;
    }

    public List<User> findAllUsers2() {
        return null;
    }

    public User findUserByUid(Integer uid) {
        return null;
    }

    public User findUserByUidUsername(Integer uid, String username) {
        return null;
    }

    public User findUserByUidUsername1(UserVO vo) {
        return null;
    }
}
