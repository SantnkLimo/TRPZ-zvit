package com.example.cps_project_console.strategy;

import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;

import java.util.List;

// Стратегія
public interface DistributionStrategy {
    void distribute(List<Goods> goods, List<User> users);
}

