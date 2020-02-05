package top.clearlight.dao;

import org.apache.ibatis.annotations.Param;
import top.clearlight.domain.User;
import top.clearlight.vo.UserVO;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void delUser(Integer uid);

    List<User> findAllUsers1();

    List<User> findAllUsers2();

    User findUserByUid(Integer uid);

    User findUserByUidUsername(@Param("uid") Integer uid, @Param("username") String username);

    User findUserByUidUsername1(UserVO vo);

}
