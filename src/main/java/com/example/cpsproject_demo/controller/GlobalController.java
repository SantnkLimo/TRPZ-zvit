package com.example.cpsproject_demo.controller;

import com.example.cpsproject_demo.model.ShoppingList;
import com.example.cpsproject_demo.model.User;
import com.example.cpsproject_demo.service.GlobalService;
import com.example.cpsproject_demo.service.GoodsService;
import com.example.cpsproject_demo.service.ShoppingListService;
import com.example.cpsproject_demo.service.UsersService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class GlobalController {
    private final UsersService usersService;
    private final GoodsService goodsService;
    private final ShoppingListService shoppingListService;
    private final GlobalService globalService;

    public GlobalController(UsersService usersService, GoodsService goodsService, ShoppingListService shoppingListService, GlobalService globalService) {
        this.usersService = usersService;
        this.goodsService = goodsService;
        this.shoppingListService = shoppingListService;
        this.globalService = globalService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = usersService.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        List<ShoppingList> shoppingLists = shoppingListService.getShoppingListsForUser(user.getId());
        model.addAttribute("shoppingLists", shoppingLists);
        model.addAttribute("users", usersService.getAllUsers());
        model.addAttribute("goods", goodsService.getAllGoods());
        return "dashboard";
    }
}
