package com.example.cpsproject_demo.model;

import com.example.cpsproject_demo.observer.Observer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Observer, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String role;

    @PrePersist
    private void setDefaultRole() {
        if (role == null) {
            role = "USER";
        }
    }
    @ManyToMany
    @JoinTable(
            name = "shopgoods",
            joinColumns = @JoinColumn(name = "good_id"),
            inverseJoinColumns = @JoinColumn(name = "shoplist_id")
    )
    private List<Goods> shoppingList;
    @ManyToMany
    @JoinTable(
            name = "usershoplist",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "shoplistid")
    )
    private List<ShoppingList> shoppingLists = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "groupid")
    private UserGroup userGroup;

    public User(){}
    public User(Long Id, String name, String email){
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.shoppingList = new ArrayList<>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role);
    }

    @Override
    public String getPassword() {
        return password;
    }
    public String getName(){
        return  name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getEmail() {
        return email;
    }

    public List<Goods> getShoppingLists() {
        return shoppingList;
    }

    public List<ShoppingList> getShoppingList() {
        return shoppingLists;
    }

    public void setShoppingList(List<ShoppingList> shoppingList) {
        this.shoppingLists = shoppingList;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setShoppingLists(List<Goods> shoppingLists) {
        this.shoppingList = shoppingLists;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public void addGoodToShoppingList(Goods good) {
        this.shoppingList.add(good);
    }




    @Override
    public String toString(){
        return "User{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", shoppingList=" + shoppingList + '\'' +
                '}';
    }
}
