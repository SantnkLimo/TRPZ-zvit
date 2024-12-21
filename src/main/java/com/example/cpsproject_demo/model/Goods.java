package com.example.cpsproject_demo.model;

import com.example.cpsproject_demo.Interface.ShoppingComponent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
public class Goods implements ShoppingComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(name = "estprice", nullable = false)
    private Double estPrice;
    @Column(name = "actprice")
    private Double actPrice;
    @ManyToOne
    @JoinColumn(name = "receiptid")
    private Receipt receipt;
    @ManyToMany(mappedBy = "shoppingList")
    private List<User> users = new ArrayList<>();

    @ManyToMany(mappedBy = "goods")
    private List<ShoppingList> shoppingLists = new ArrayList<>();

    public Goods(){

    }
    public Goods(Long id, String name, String description, double estPrice, double actPrice){
        this.Id = id;
        this.name = name;
        this.description = description;
        this.estPrice = estPrice;
        this.actPrice = actPrice;
    }

    public Goods(String name, String description, double estPrice) {
        this.name = name;
        this.description = description;
        this.estPrice = estPrice;
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

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }
}
