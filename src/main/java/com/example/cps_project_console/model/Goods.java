package com.example.cps_project_console.model;

import com.example.cps_project_console.Interface.ShoppingComponent;

public class Goods implements ShoppingComponent {
    private Long Id;
    private String name;
    private String description;
    private double estPrice;
    private double actPrice;
    private Receipt receipt;

    public Goods(){

    }
    public Goods(Long id, String name, String description, Double estPrice, Double actPrice){
        this.Id = id;
        this.name = name;
        this.description = description;
        this.estPrice = estPrice;
        this.actPrice = actPrice;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public double getEstPrice() {
        return estPrice;
    }
    public double getActPrice() {
        return actPrice;
    }
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    public void setId(Long id) {
        Id = id;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public Goods setDescription(String description) {
        this.description = description;
        return this;
    }

    public Goods setEstPrice(double price) {
        this.estPrice = price;
        return this;
    }
    public Goods setActPrice(double price) {
        this.actPrice = price;
        return this;
    }
    @Override
    public double getTotalPrice() {
        return actPrice;
    }

    @Override
    public void display() {
        System.out.println("Goods: " + name + ", Price: " + actPrice);
    }
    @Override
    public String toString(){
        return "Goods{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", desc='" + description + '\'' +
                ", Estimated price=" + estPrice + '\'' +
                ", Actual price=" + actPrice + '\'' +
                ", receipt=" + (receipt != null ? receipt.toString() : "No receipt") +
                '}';
    }
}
