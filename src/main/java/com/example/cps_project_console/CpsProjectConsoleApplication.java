package com.example.cps_project_console;

import com.example.cps_project_console.Interface.GroupPurchase;
import com.example.cps_project_console.model.Goods;
import com.example.cps_project_console.model.User;
import com.example.cps_project_console.model.UserGroup;
import com.example.cps_project_console.strategy.CostBasedDistributionStrategy;
import com.example.cps_project_console.strategy.DistributionStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CpsProjectConsoleApplication {
        public static void main(String[] args) {
            SpringApplication.run(CpsProjectConsoleApplication.class, args);
            User user1 = new User(1L, "Alice", "alice@example.com");
            User user2 = new User(2L, "Bob", "bob@example.com");

            Goods cake = new Goods(1L, "Cake", "Birthday cake", 30.0, 30.0);
            Goods candles = new Goods(2L, "Candles", "Pack of candles", 5.0, 5.0);

            UserGroup birthdayGroup = new UserGroup.Builder()
                    .withGroupName("Birthday Party")
                    .addParticipant(user1)
                    .addParticipant(user2)
                    .addGoods(cake)
                    .addGoods(candles)
                    .build();

            System.out.println("Participants: " + birthdayGroup.getParticipants());
            System.out.println("Goods: " + birthdayGroup.getGoodsList());

        }
}

