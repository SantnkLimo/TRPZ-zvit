package com.example.cps_project_console;

import com.example.cps_project_console.Interface.GroupPurchase;
import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;
import com.example.cps_project_console.strategy.CostBasedDistributionStrategy;
import com.example.cps_project_console.strategy.DistributionStrategy;
import com.example.cps_project_console.strategy.EvenDistributionStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CpsProjectConsoleApplication {
        public static void main(String[] args) {
            SpringApplication.run(CpsProjectConsoleApplication.class, args);
            List<Goods> goodsList = List.of(
                    new Goods(1L, "Laptop", "Electronics", 1200.0, 1200.0),
                    new Goods(2L, "Phone", "Electronics", 800.0, 800.0),
                    new Goods(3L, "Headphones", "Accessories", 200.0, 200.0),
                    new Goods(4L, "Mouse", "Accessories", 50.0, 50.0),
                    new Goods(5L, "Keyboard", "Accessories", 100.0, 100.0)
            );

            List<User> users = List.of(
                    new User("Alice"),
                    new User("Bob"),
                    new User("Charlie")
            );

            DistributionStrategy strategy = new EvenDistributionStrategy();
            GroupPurchase groupPurchase = new GroupPurchase(strategy);

            groupPurchase.executeDistribution(goodsList, users);

            users.forEach(user -> {
                System.out.println(user.getName() + "'s shopping list: " + user.getShoppingLists());
                System.out.println("Total cost: " + user.getShoppingLists().stream()
                        .mapToDouble(Goods::getActPrice).sum());
            });
        }
    }

