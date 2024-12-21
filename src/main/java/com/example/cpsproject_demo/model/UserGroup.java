package com.example.cpsproject_demo.model;

import com.example.cpsproject_demo.observer.Observer;
import com.example.cpsproject_demo.observer.Subject;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usergroup")
public class UserGroup implements Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @Column(nullable = false)
    private String groupName;
    @OneToMany(mappedBy = "userGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> participants;
    @ManyToMany
    @JoinTable(
            name = "usergroupshoplist",
            joinColumns = @JoinColumn(name = "usergroupid"),
            inverseJoinColumns = @JoinColumn(name = "shoplistid")
    )
    private List<Goods> goodsList;
    @Transient
    private List<Observer> observers;

    private UserGroup(Builder builder) {
        this.groupId = builder.groupId;
        this.groupName = builder.groupName;
        this.participants = builder.participants;
        this.goodsList = builder.goodsList;
        this.observers = new ArrayList<>(builder.participants);
    }

    public UserGroup() {

    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addParticipant(User user) {
        participants.add(user);
        addObserver(user);
        notifyObservers(user.getName() + " joined the group " + groupName);
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
        notifyObservers("New item added to " + groupName + ": " + goods.getName());
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupName='" + groupName + '\'' +
                ", participants=" + participants +
                ", goodsList=" + goodsList +
                '}';
    }

    public static class Builder {
        private Long groupId;
        private String groupName;
        private List<User> participants = new ArrayList<>();
        private List<Goods> goodsList = new ArrayList<>();

        public Builder withGroupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }
        public Builder withGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder addParticipant(User user) {
            this.participants.add(user);
            return this;
        }

        public Builder addGoods(Goods goods) {
            this.goodsList.add(goods);
            return this;
        }

        public UserGroup build() {
            return new UserGroup(this);
        }
    }
}
