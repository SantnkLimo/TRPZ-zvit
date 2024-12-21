package com.example.cpsproject_demo.service;

import com.example.cpsproject_demo.Interface.UserDAO;
import com.example.cpsproject_demo.model.User;
import com.example.cpsproject_demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GlobalService implements UserDAO {
    private final UserRepository userRepository;
    public GlobalService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public List<User> getAllUsers(){return userRepository.findAll();}
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Flower not found"));
    }
    @Override
    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }
    @Override
    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("Flower not found");
        }
        userRepository.save(user);
    }
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Flower not found");
        }
        userRepository.deleteById(id);
    }
    public List<User> searchUsers(String name) {
        return userRepository.findByName(name);
    }
}
