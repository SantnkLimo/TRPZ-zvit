package com.example.cpsproject_demo.service;

import com.example.cpsproject_demo.adapter.GoodsAdapter;
import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.Receipt;
import com.example.cpsproject_demo.model.ShoppingList;
import com.example.cpsproject_demo.model.User;
import com.example.cpsproject_demo.repository.GoodsRepository;
import com.example.cpsproject_demo.repository.ShoppingListRepository;
import com.example.cpsproject_demo.strategy.DistributionStrategy;

import java.util.List;
import java.util.Optional;

public class SystemFacade extends UserService {

    private final GoodsRepository goodsRepository;
    private final ShoppingListRepository shoppingListRepository;

    public SystemFacade(GoodsRepository goodsRepository, ShoppingListRepository shoppingListRepository) {
        this.goodsRepository = goodsRepository;
        this.shoppingListRepository = shoppingListRepository;
    }


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
    public void attachGoodToList(Long shoppingListId, Long goodId) {
        Optional<Goods> targetGood = goodsRepository.findById(goodId);
        if (targetGood.isEmpty()) {
            System.out.println("Good with ID " + goodId + " not found in the system.");
            return;
        }

        Optional<ShoppingList> targetList = shoppingListRepository.findById(shoppingListId);
        if (targetList.isPresent()) {
            ShoppingList shoppingList = targetList.get();
            Goods good = targetGood.get();

            shoppingList.addComponent(new GoodsAdapter(good));

            // Добавляем список в товар
            good.getShoppingLists().add(shoppingList);

            // Сохраняем изменения в базе данных
            shoppingListRepository.save(shoppingList);
            goodsRepository.save(good);

            System.out.println("Good '" + good.getName() + "' added to Shopping List with ID " + shoppingListId);
        } else {
            System.out.println("Shopping List with ID " + shoppingListId + " not found.");
        }
    }

    public void displayAllShoppingLists() {
        System.out.println("---- All Shopping Lists ----");
        getLists().forEach(ShoppingList::display);
    }
}
