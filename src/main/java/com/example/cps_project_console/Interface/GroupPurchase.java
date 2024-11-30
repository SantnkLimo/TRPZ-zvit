package com.example.cps_project_console.Interface;

import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;
import com.example.cps_project_console.strategy.DistributionStrategy;

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
