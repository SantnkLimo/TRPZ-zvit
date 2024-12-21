package com.example.cps_project_console.service;

import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.Receipt;
import com.example.cps_project_console.model.User;
import com.example.cps_project_console.strategy.DistributionStrategy;

import java.util.List;

public class SystemFacade extends UserService {



    public void createAndDistributeShoppingList(List<User> users, List<Goods> goods, DistributionStrategy strategy) {
        strategy.distribute(goods, users);
        System.out.println("Shopping list distributed using " + strategy.getClass().getSimpleName());
    }

    public void attachReceiptToGood(List<User> users, Long userId, Long goodId, Receipt receipt) {
        User user = findUserById(users, userId);
        if (user != null) {
            Goods good = user.getShoppingLists().stream()
                    .filter(g -> g.getId().equals(goodId))
                    .findFirst()
                    .orElse(null);

            if (good != null) {
                good.setReceipt(receipt);
                good.setActPrice(receipt.getAmount());
                System.out.println("Receipt attached to " + good.getName());
            } else {
                System.out.println("Good not found for user " + user.getName());
            }
        } else {
            System.out.println("User not found with ID " + userId);
        }
    }
}
