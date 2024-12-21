package com.example.cps_project_console.strategy;

import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;

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
