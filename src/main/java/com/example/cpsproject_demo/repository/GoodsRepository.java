package com.example.cpsproject_demo.repository;

import com.example.cpsproject_demo.model.Goods;
import com.example.cpsproject_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAll();
    List<Goods> findByName(String name);
}
