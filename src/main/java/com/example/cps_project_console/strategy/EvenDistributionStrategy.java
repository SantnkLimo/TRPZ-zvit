package com.example.cps_project_console.strategy;

import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EvenDistributionStrategy implements DistributionStrategy {
    @Override
    public void distribute(List<Goods> goodsList, List<User> users) {

        List<Goods> mutableGoodsList = new ArrayList<>(goodsList);
        mutableGoodsList.sort(Comparator.comparingDouble(Goods::getActPrice).reversed());

        if (users.isEmpty() || goodsList.isEmpty()) {
            System.out.println("Cannot distribute: either users or goods are empty.");
            return;
        }

        int userCount = users.size();
        int index = 0;

        for (Goods goods : goodsList) {
            User assignedUser = users.get(index % userCount);
            assignedUser.addGoodToShoppingList(goods);
            System.out.println("Assigned " + goods.getName() + " to " + assignedUser.getName());
            index++;
        }
    }
}
