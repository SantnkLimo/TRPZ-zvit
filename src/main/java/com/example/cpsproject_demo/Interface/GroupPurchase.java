package com.example.cpsproject_demo.Interface;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.User;
import com.example.cpsproject_demo.strategy.DistributionStrategy;

import java.util.List;

public class GroupPurchase {
    private DistributionStrategy strategy;

    public GroupPurchase(DistributionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DistributionStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeDistribution(List<Goods> goods, List<User> users) {
        strategy.distribute(goods, users);
    }
}
