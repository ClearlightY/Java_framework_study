package top.clearlight.dao;

import top.clearlight.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/11 16:58
 */
public interface UserDao {

    /**
     * 查询所有用户
     */
    List<User> findAll();

    /**
     * 保存用户
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询用户信息
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     */
    int findTotal();

}
