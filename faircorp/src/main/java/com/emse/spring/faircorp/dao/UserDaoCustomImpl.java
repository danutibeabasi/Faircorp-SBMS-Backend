package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Role;
import com.emse.spring.faircorp.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserDaoCustomImpl implements UserDaoCustom {

    private final UserDao userDao;
    private final RoleDao roleDao;


    public UserDaoCustomImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userDao.findByUsername(username);
        Role role = roleDao.findByName(roleName);
//        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }


}
