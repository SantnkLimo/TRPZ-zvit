package com.example.cpsproject_demo.controller;

import com.example.cpsproject_demo.model.ShoppingList;
import com.example.cpsproject_demo.repository.*;
import com.example.cpsproject_demo.service.GoodsService;
import com.example.cpsproject_demo.service.ShoppingListService;
import com.example.cpsproject_demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shoppingList")
public class ShoppingController {
    private final ShoppingListService shoppingListService ;
    private final UsersService usersService;
    private final GoodsService goodsService;



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    public ShoppingController(ShoppingListService shoppingListService, UsersService usersService, GoodsService goodsService) {
        this.shoppingListService = shoppingListService;
        this.usersService = usersService;
        this.goodsService = goodsService;
    }

    @GetMapping("/create")
    public String showCreateListForm(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        model.addAttribute("goods", goodsService.getAllGoods());
        model.addAttribute("shoppingList", new ShoppingList());
        return "createShoppingList";
    }

    @PostMapping("/create")
    public String createShoppingList(@RequestParam String name,
                                     @RequestParam List<Long> userIds,
                                     @RequestParam List<Long> goodsIds) {

        shoppingListService.createShoppingList(name, userIds, goodsIds);

        return "redirect:/shoppingList/success";
    }

    @GetMapping("/success")
    public String success() {
        return "shoppingListSuccess";
    }

    @GetMapping("/{id}")
    public String viewShoppingList(@PathVariable Long id, Model model) {
        ShoppingList shoppingList = shoppingListService.getShoppingListById(id)
                .orElseThrow(() -> new IllegalArgumentException("Список покупок не найден"));
        model.addAttribute("shoppingList", shoppingList);
        return "shoppingListView";
    }
}
