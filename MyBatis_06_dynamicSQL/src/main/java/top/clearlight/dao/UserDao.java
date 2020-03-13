package top.clearlight.dao;

import top.clearlight.domain.QueryVo;
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

    /**
     * 根据queryVo的条件查询用户
     *
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件: 有可能有用户名, 有可能有性别, 也有可能有地址, 还有可能是都有
     * @return
     */
    List<User> findUserByCondition(User user);
}
