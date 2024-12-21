package com.example.cpsproject_demo.model;


import com.example.cpsproject_demo.Interface.ShoppingComponent;
import com.example.cpsproject_demo.adapter.GoodsAdapter;
import com.example.cpsproject_demo.observer.Observer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "shoppinglist")
public class ShoppingList implements ShoppingComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "shoppingLists")
    private List<User> user = new ArrayList<>();
    @Transient
    private List<ShoppingComponent> components = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "shopgoods",
            joinColumns = @JoinColumn(name = "shoplist_id"),
            inverseJoinColumns = @JoinColumn(name = "good_id")
    )
    private List<Goods> goods = new ArrayList<>();

    @Transient
    private List<Observer> observers = new ArrayList<>();

    public ShoppingList(Long Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public ShoppingList() {

    }

    public String getName() {
        return name;
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public List<User> getUsers() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public List<ShoppingComponent> getComponents() {
        if (components == null) {
            components = goods.stream()
                    .map(GoodsAdapter::new)
                    .collect(Collectors.toList());
        }
        return components;
    }

    public void setGoods(List<ShoppingComponent> components) {
        this.goods = components.stream()
                .filter(c -> c instanceof GoodsAdapter)
                .map(c -> ((GoodsAdapter) c).getGood())
                .collect(Collectors.toList());
    }

    public void addComponent(ShoppingComponent component) {
        if (component instanceof GoodsAdapter) {
            this.goods.add(((GoodsAdapter) component).getGood());
        } else {
            throw new IllegalArgumentException("Unsupported component type");
        }
    }
    public void deleteComponent(ShoppingComponent component) {
        if (component instanceof GoodsAdapter) {
            Goods good = ((GoodsAdapter) component).getGood();
            if (goods.contains(good)) {
                goods.remove(good);
                good.getShoppingLists().remove(this);
            }
        } else {
            throw new IllegalArgumentException("Unsupported component type");
        }
    }

    @Override
    public double getTotalPrice() {
        return components.stream().mapToDouble(ShoppingComponent::getTotalPrice).sum();
    }

    @Override
    public void display() {
        System.out.println("List: " + name);
        for (ShoppingComponent component : components) {
            component.display();
        }
    }
}
