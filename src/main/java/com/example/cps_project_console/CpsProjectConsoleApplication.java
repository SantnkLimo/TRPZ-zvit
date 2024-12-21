package com.example.cps_project_console;

import com.example.cps_project_console.Interface.GroupPurchase;
import com.example.cps_project_console.model.*;
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
            SystemFacade systemFacade = new SystemFacade();

            systemFacade.attachGoodToList(1L, 1L);
            systemFacade.attachGoodToList(2L, 3L);
            systemFacade.attachGoodToList(2L, 5L);

            ShoppingList allShopping = new ShoppingList(3L,"All Shopping");
            systemFacade.getLists().forEach(allShopping::addComponent);

            System.out.println("---- All Shopping List ----");
            allShopping.display();
        }
}

