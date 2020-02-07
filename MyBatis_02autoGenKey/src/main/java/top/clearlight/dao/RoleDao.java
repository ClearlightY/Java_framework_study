package top.clearlight.dao;

import top.clearlight.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findRolesByUid(Integer uid);
}
