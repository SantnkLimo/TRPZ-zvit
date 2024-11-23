package com.example.cps_project_console.model;

import com.example.cps_project_console.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private Long Id;
    private String name;
    private String email;
    private List<Goods> shoppingList;

    public User(){}
    public User(Long Id, String name, String email){
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.shoppingList = new ArrayList<>();
    }
    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Goods> getShoppingLists() {
        return shoppingList;
    }
    public void setId(Long id) {
        Id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setShoppingLists(List<Goods> shoppingLists) {
        this.shoppingList = shoppingLists;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public void addGoodToShoppingList(Goods good) {
        this.shoppingList.add(good);
    }


    @Override
    public String toString(){
        return "User{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", shoppingList=" + shoppingList + '\'' +
                '}';
    }
}
