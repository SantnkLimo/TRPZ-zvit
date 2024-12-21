package com.example.cpsproject_demo.strategy;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.User;

import java.util.List;

// Конкретна стратегія 2: розподіл за вартістю
import java.util.ArrayList;
import java.util.Comparator;

public class CostBasedDistributionStrategy implements DistributionStrategy {
    @Override
    public void distribute(List<Goods> goods, List<User> users) {

        List<Goods> mutableGoodsList = new ArrayList<>(goods);
        mutableGoodsList.sort(Comparator.comparingDouble(Goods::getActPrice).reversed());

        users.forEach(user -> user.setShoppingLists(new ArrayList<>()));

        double[] userCosts = new double[users.size()];

        for (Goods good : goods) {
            int minCostIndex = 0;
            for (int i = 1; i < userCosts.length; i++) {
                if (userCosts[i] < userCosts[minCostIndex]) {
                    minCostIndex = i;
                }
            }

            users.get(minCostIndex).getShoppingLists().add(good);

            userCosts[minCostIndex] += good.getActPrice();
        }
    }
}

