package com.gmil.chernii.oleksii.dao;

import com.gmil.chernii.oleksii.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void insert(User user);

    Optional<User> getById(Long id);

    void update(User user);

    void deleteById(Long id);

    List<User> getAllUsers();
}
