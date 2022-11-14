package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);


}
