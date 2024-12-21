package com.example.cpsproject_demo.observer;

public class ShoppingObserver implements Observer {
    private String serviceName;

    public ShoppingObserver(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void update(String message) {
        System.out.println(serviceName + " received notification: " + message);
    }
}
