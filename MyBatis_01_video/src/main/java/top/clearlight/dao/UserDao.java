package top.clearlight.dao;

import top.clearlight.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {

    /**
     * 查询所有操作
     */
    List<User> findAll();

}
