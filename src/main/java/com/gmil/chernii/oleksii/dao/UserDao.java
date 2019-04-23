package com.gmil.chernii.oleksii.dao;

import com.gmil.chernii.oleksii.entity.User;

import java.util.List;

/**
 * Created by Space on 23.04.2019.
 */
public interface UserDao {
    void insert(User user);

    User getById(Long id);

    void update(User user);

    void deleteById(Long id);

    List<User> getAllUsers();
}
