package com.example.cpsproject_demo.adapter;

import com.example.cpsproject_demo.Interface.ShoppingComponent;
import com.example.cpsproject_demo.model.Goods;

public class GoodsAdapter implements ShoppingComponent {
    private final Goods good;

    public GoodsAdapter(Goods good) {
        this.good = good;
    }

    @Override
    public double getTotalPrice() {
        return good.getActPrice();
    }

    @Override
    public void display() {
        System.out.println("Item: " + good.getName() + ", Price: " + good.getActPrice());
    }
    public Goods getGood() {
        return good;
    }
}

