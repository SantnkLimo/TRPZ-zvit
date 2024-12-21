package com.example.cpsproject_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CpsProjectDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpsProjectDemoApplication.class, args);
//        SystemFacade facade = new SystemFacade(goodsRepository, shoppingListRepository);
//        UserService userService = new UserService();
//        List<User> users = userService.getUsers();
//        List<Goods> goods = userService.getGoods();
//        // ====== 1. BUILDER ======
//        // Создаем группу пользователей для совместной покупки через билдер
//        UserGroup userGroup = new UserGroup.Builder()
//                .withGroupId(1L)
//                .withGroupName("Tech Enthusiasts")
//                .addParticipant(users.get(0))
//                .addParticipant(users.get(1))
//                .build();
//
//        System.out.println("User Group created: " + userGroup.getGroupName());
//
//        // ====== 2. OBSERVER ======
//        // Создаем наблюдателя для оповещения при изменении списка товаров
//        ShoppingList electronics = new ShoppingList(1L, "Electronics");
//        ShoppingObserver observer = new ShoppingObserver("Notification Service");
//        electronics.addObserver(observer);
//
//
//        // Добавляем товары в списки через фасад
//        facade.attachGoodToList(1L, 1L); // "Laptop" -> Electronics
//        facade.attachGoodToList(1L, 2L); // "Phone" -> Electronics
//        facade.attachGoodToList(2L, 3L); // "Apple" -> Groceries
//
//        // ====== 4. STRATEGY ======
//        // Распределяем товары между пользователями с использованием стратегии
//        DistributionStrategy strategy = new CostBasedDistributionStrategy();
//        facade.createAndDistributeShoppingList(userGroup.getParticipants(), facade.getGoods(), strategy);
//
//        // ====== 5. COMPOSITE ======
//        // Создаем общий список покупок, объединяющий все категории
//        ShoppingList allShopping = new ShoppingList(3L, "All Shopping");
//        facade.getLists().forEach(allShopping::addComponent);
//
//        Receipt receipt = new Receipt(1L, 1200.0, LocalDate.now(), "Receipt for Laptop");
//        facade.attachReceiptToGood(users, 1L, 1L, receipt); // "Laptop" -> Receipt
//
//        // ====== Итоговый вывод ======
//        System.out.println("\n---- All Shopping List ----");
//        allShopping.display();
//
//        System.out.println("\n---- User's Shopping Lists ----");
//        userGroup.getParticipants().forEach(user -> {
//            System.out.println(user.getName() + "'s Shopping List: " + user.getShoppingLists());
//        });
//
//        // Добавляем чек для товара

    }

}
