package com.example.cpsproject_demo.strategy;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.User;

import java.util.List;

// Стратегія
public interface DistributionStrategy {
    void distribute(List<Goods> goods, List<User> users);
}

