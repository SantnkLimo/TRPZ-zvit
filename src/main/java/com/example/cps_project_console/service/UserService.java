package com.example.cps_project_console.service;

import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;

import java.util.List;


public class UserService {
    public List<User> getUsers() {
        return List.of(
                new User(1L, "Alice", "alice@example.com"),
                new User(2L, "Bob", "bob@example.com")
        );
    }
    public List<Goods> getGoods() {
        return List.of(
                new Goods(1L, "Laptop", "Electronics", 1200.0, 1200.0),
                new Goods(2L, "Phone", "Electronics", 800.0, 800.0)
        );
    }
    public User findUserById(List<User> users, Long userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
