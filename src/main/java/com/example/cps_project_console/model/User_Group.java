package com.example.cps_project_console.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User_Group {
    private Long Id;
    private Set<User> users;
    private Set<ShoppingList> shoppingLists;

    public User_Group(){
        this.users = new HashSet<>();
        this.shoppingLists = new HashSet<>();
    }

    @Override
    public String toString() {
        return "User_Group{" +
                "id=" + Id +
                ", name='" + users + '\'' +
                ", list=" + shoppingLists +
                '}';
    }
}
