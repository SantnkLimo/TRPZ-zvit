package com.example.cpsproject_demo.service;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.ShoppingList;
import com.example.cpsproject_demo.model.User;
import com.example.cpsproject_demo.repository.GoodsRepository;
import com.example.cpsproject_demo.repository.ShoppingListRepository;
import com.example.cpsproject_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;

    @Autowired
    public ShoppingListService(ShoppingListRepository shoppingListRepository,
                               UserRepository userRepository,
                               GoodsRepository goodsRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
        this.goodsRepository = goodsRepository;
    }


    public ShoppingList createShoppingList(String name, List<Long> userIds, List<Long> goodsIds) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setName(name);
        shoppingList = shoppingListRepository.save(shoppingList);

        List<User> users = userRepository.findAllById(userIds);
        if (users.isEmpty()) {
            throw new IllegalArgumentException("Не знайдено користувачів з указанними ID");
        }
        shoppingList.setUsers(users);

        List<Goods> goods = goodsRepository.findAllById(goodsIds);
        if (goods.isEmpty()) {
            throw new IllegalArgumentException("Не знайдено товарів з указанними ID");
        }
        for (Goods good : goods) {
            shoppingList.addComponent(good);
        }
        return shoppingListRepository.save(shoppingList);
    }

    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListRepository.findAll();
    }

    public Optional<ShoppingList> getShoppingListById(Long id) {
        return shoppingListRepository.findById(id);
    }

    public void deleteShoppingList(Long id) {
        shoppingListRepository.deleteById(id);
    }
    @Transactional
    public void addGoodsToShoppingList(Long shoppingListId, List<Long> goodsIds) {
        ShoppingList shoppingList = shoppingListRepository.findById(shoppingListId)
                .orElseThrow(() -> new RuntimeException("Список покупок з ID " + shoppingListId + " не знайдено"));

        List<Goods> goods = goodsRepository.findAllById(goodsIds);
        for (Goods good : goods) {
            shoppingList.addComponent(good);
        }

        shoppingListRepository.save(shoppingList);
    }

    @Transactional
    public void removeGoodsFromShoppingList(Long shoppingListId, List<Long> goodsIds) {
        ShoppingList shoppingList = shoppingListRepository.findById(shoppingListId)
                .orElseThrow(() -> new RuntimeException("Список покупок с ID " + shoppingListId + " не найден"));

        List<Goods> goods = goodsRepository.findAllById(goodsIds);
        for (Goods good : goods) {
            shoppingList.deleteComponent(good);
        }

        shoppingListRepository.save(shoppingList);
    }
    public List<ShoppingList> getShoppingListsForUser(Long userId) {
        return shoppingListRepository.findByUserId(userId);
    }
}

