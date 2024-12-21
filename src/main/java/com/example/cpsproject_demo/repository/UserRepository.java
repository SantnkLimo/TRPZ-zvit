package com.example.cpsproject_demo.repository;

import com.example.cpsproject_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
