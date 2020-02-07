package top.clearlight.dao;

import top.clearlight.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserDao {
    void saveUser1(User user);

    void saveUser2(User user);

    /**
     * 动态插入
     *
     * @param user
     */
    void saveUser3(User user);

    /**
     * 动态生成查询条件
     */
    List<User> findUsers(User vo);

    /**
     * 动态更新
     */
    void updateUser(User user);

    List<User> findUsers1(Integer[] uids);

    List<User> findUsers2(List<Integer> uids);

    List<User> findUsers3(Set<Integer> uids);

    List<User> findUsers4(Map<String, Integer> uids);

    /**
     * 动态生成查询条件
     */
    List<User> findUsers5(User vo);

    List<User> findAllUsersWithAccounts();

    List<User> findAllUsersWithRoles();

    User findUserByUid(Integer uid);

    List<User> findAllUsersWithRoles1();

}
