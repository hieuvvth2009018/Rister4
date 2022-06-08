package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserModel implements UserModel {

    private static List<User> users;

    public InMemoryUserModel() {
        users = new ArrayList<>();
    }

    @Override
    public boolean save(User user) {
        users.add(user);
        return true;
    }

    @Override
    public boolean update(int id, User updateUser) {
        int foundIndex = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            users.get(foundIndex).setUsername(updateUser.getUsername());
            users.get(foundIndex).setPasswordHash(updateUser.getPasswordHash());
            users.get(foundIndex).setStatus(updateUser.getStatus());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        int foundIndex = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            users.remove(foundIndex);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }
}
