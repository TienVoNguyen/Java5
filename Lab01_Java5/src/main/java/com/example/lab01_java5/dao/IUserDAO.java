package com.example.lab01_java5.dao;

import com.example.lab01_java5.models.User;

import java.util.List;

public interface IUserDAO {
    Long save(User user);

    User findById(Long id);

    List<User> findAll();

    User getUserByEmailPass(User user);

    User update(User user);
}
