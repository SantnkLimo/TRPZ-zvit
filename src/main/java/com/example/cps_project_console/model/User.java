package com.example.cps_project_console.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long Id;
    private String name;
    private String email;
    private List<Goods> shoppingList  = new ArrayList<>();

    public User(){
        this.shoppingList = new ArrayList<>();
    }
    public User(Long Id, String name, String email){
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.shoppingList = new ArrayList<>();
    }
    public User(String name){
        this.name = name;
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

}
