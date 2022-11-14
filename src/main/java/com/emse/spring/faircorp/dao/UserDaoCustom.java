package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Role;
import com.emse.spring.faircorp.model.User;

import java.util.List;

public interface UserDaoCustom {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
