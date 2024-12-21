package com.example.cpsproject_demo.Interface;

import com.example.cpsproject_demo.model.Goods;

import java.util.List;

public interface GoodsDAO {
    Long saveGoods(Goods goods);
    Goods getGoodsById(Long id);
    void updateGoods(Goods user);
    void deleteGoods(Long id);
    List<Goods> searchGoods(String name);
}
