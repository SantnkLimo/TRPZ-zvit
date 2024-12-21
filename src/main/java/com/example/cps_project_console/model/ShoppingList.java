package com.example.cps_project_console.model;


import com.example.cps_project_console.Interface.ShoppingComponent;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements ShoppingComponent {
    private Long Id;
    private String name;
    private List<ShoppingComponent> components = new ArrayList<>();

    public ShoppingList(Long Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return Id;
    }

    public List<ShoppingComponent> getComponents() {
        return components;
    }

    public void addComponent(ShoppingComponent component) {
        components.add(component);
    }

    public void removeComponent(ShoppingComponent component) {
        components.remove(component);
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
