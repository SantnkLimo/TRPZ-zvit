package com.example.cpsproject_demo.controller;


import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodController {
    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/create-goods")
    public String showCreateProductPage() {
        return "createGood";
    }

    @PostMapping("/create-goods")
    public String createProduct(
            @RequestParam String Name,
            @RequestParam String Description,
            @RequestParam double estPrice,
            Model model) {

        Goods goods = new Goods(Name, Description, estPrice);

        goodsRepository.save(goods);

        model.addAttribute("message", "Товар успішно створено!");

        return "redirect:/goods";
    }
    @GetMapping("/goods")
    public String showGoodsPage(Model model) {
        Iterable<Goods> goods = goodsRepository.findAll();

        model.addAttribute("goods", goods);
        return "goods";
    }
}
