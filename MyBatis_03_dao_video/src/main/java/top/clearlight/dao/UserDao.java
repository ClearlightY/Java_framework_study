package top.clearlight.dao;

import org.apache.ibatis.annotations.Select;
import top.clearlight.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {

    /**
     * 查询所有操作
     */
    // @Select("select * from user")
    List<User> findAll();
}
