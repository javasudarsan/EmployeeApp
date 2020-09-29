package com.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
