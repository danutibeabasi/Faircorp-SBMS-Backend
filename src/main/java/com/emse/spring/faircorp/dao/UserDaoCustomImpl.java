package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Role;
import com.emse.spring.faircorp.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Provides custom data access functionality for users.
 * This class implements the methods defined in the UserDaoCustom interface to provide concrete implementations for interacting with a database of users and roles.
 */
@Service
@Transactional
public class UserDaoCustomImpl implements UserDaoCustom {

    private final UserDao userDao;
    private final RoleDao roleDao;

    /**
     * Constructs a new UserDaoCustomImpl instance.
     *
     * @param userDao the data access object for users
     * @param roleDao the data access object for roles
     */
    public UserDaoCustomImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userDao.findByUsername(username);
        Role role = roleDao.findByName(roleName);
//        user.getRoles().add(role);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }


}
