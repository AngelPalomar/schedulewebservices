package com.example.schedulewebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulewebservices.models.User;

public interface UserDao extends JpaRepository<User, String> {
    User findByName(String user_name);
}
