package com.example.cpsproject_demo.repository;


import com.example.cpsproject_demo.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    List<ShoppingList> findByUserId(Long userId);
}
