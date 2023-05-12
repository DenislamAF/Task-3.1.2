package com.example.task_3_1_2.dao;

import com.example.task_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void remove(int id);

    void update(User user);

    List<User> getAllUsers();
}
