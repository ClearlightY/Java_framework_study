package top.clearlight.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.clearlight.dao.UserDao;
import top.clearlight.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1. 使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        // 2. 使用session执行查询所有方法
        List<User> users = session.selectList("top.clearlight.dao.UserDao.findAll");
        // 3. 返回查询结果
        return users;
    }
}
