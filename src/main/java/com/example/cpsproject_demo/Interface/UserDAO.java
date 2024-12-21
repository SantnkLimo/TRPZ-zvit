package com.example.cpsproject_demo.Interface;

import com.example.cpsproject_demo.model.User;

import java.util.List;

public interface UserDAO {
    Long saveUser(User user);
    User getUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> searchUsers(String name);
}
