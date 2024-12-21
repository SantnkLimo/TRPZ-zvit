package com.example.cpsproject_demo.service;

import com.example.cpsproject_demo.Interface.GoodsDAO;
import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService implements GoodsDAO {
    private final GoodsRepository goodsRepository;
    public GoodsService(GoodsRepository userRepository){
        this.goodsRepository = userRepository;
    }



    public List<Goods> getAllGoods(){return goodsRepository.findAll();}
    public Goods getGoodsById(Long id) {
        return goodsRepository.findById(id).orElseThrow(() -> new RuntimeException("Flower not found"));
    }
    @Override
    public Long saveGoods(Goods goods) {
        return goodsRepository.save(goods).getId();
    }
    @Override
    public void updateGoods(Goods goods) {
        if (!goodsRepository.existsById(goods.getId())) {
            throw new RuntimeException("Flower not found");
        }
        goodsRepository.save(goods);
    }
    public void deleteGoods(Long id) {
        if (!goodsRepository.existsById(id)) {
            throw new RuntimeException("Flower not found");
        }
        goodsRepository.deleteById(id);
    }
    public List<Goods> searchGoods(String name) {
        return goodsRepository.findByName(name);
    }
}
