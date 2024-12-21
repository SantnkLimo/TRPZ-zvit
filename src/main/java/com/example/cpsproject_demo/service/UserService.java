package com.example.cpsproject_demo.service;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.ShoppingList;
import com.example.cpsproject_demo.model.User;

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
                new Goods(2L, "Phone", "Electronics", 800.0, 800.0),
                new Goods(3L, "Apple", "Fruit", 1.0, 1.0),
                new Goods(4L, "Bread", "Bakery", 2.5, 2.5)
        );
    }
    public List<ShoppingList> getLists() {
        return List.of(
                new ShoppingList(1L, "Electronics"),
                new ShoppingList(2L,"Groceries")
        );
    }
    public User findUserById(List<User> users, Long userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
