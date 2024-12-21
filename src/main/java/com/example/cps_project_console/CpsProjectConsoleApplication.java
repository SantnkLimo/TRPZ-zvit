package com.example.cps_project_console;

import com.example.cps_project_console.Interface.GroupPurchase;
import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.Receipt;
import com.example.cps_project_console.model.User;
import com.example.cps_project_console.model.UserGroup;
import com.example.cps_project_console.service.SystemFacade;
import com.example.cps_project_console.service.UserService;
import com.example.cps_project_console.strategy.CostBasedDistributionStrategy;
import com.example.cps_project_console.strategy.DistributionStrategy;
import com.example.cps_project_console.strategy.EvenDistributionStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class CpsProjectConsoleApplication {
        public static void main(String[] args) {
            SpringApplication.run(CpsProjectConsoleApplication.class, args);
                SystemFacade facade = new SystemFacade();
                UserService userService = new UserService();

                List<User> users = userService.getUsers();
                List<Goods> goods = userService.getGoods();
                Receipt receipt = new Receipt(1L, 750.0, LocalDate.now(), "Payment for Phone");


                facade.createAndDistributeShoppingList(users, goods, new EvenDistributionStrategy());
                facade.attachReceiptToGood(users, 2L, 2L, receipt);
                users.forEach(user -> {
                    System.out.println(user.getName() + "'s shopping list: " + user.getShoppingLists());
                });
            }
}

