package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.User;

import java.util.List;

public interface UserModel {
    boolean save(User user);
    boolean update(int id, User updateUser);
    boolean delete(int id);
    List<User> findAll();
    User findById(int id);
}
