package com.example.cpsproject_demo.strategy;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.User;

import java.util.List;

public class EvenDistributionStrategy implements DistributionStrategy {
    @Override
    public void distribute(List<Goods> goods, List<User> users) {
        if (users.isEmpty() || goods.isEmpty()) {
            System.out.println("No users or goods to distribute.");
            return;
        }
        int userIndex = 0;
        for (Goods good : goods) {
            users.get(userIndex).addGoodToShoppingList(good);
            userIndex = (userIndex + 1) % users.size();
        }
    }
}
