package com.example.cps_project_console.model;

import com.example.cps_project_console.observer.Observer;
import com.example.cps_project_console.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class UserGroup implements Subject {
    private String groupName;
    private List<User> participants;
    private List<Goods> goodsList;
    private List<Observer> observers;

    private UserGroup(Builder builder) {
        this.groupName = builder.groupName;
        this.participants = builder.participants;
        this.goodsList = builder.goodsList;
        this.observers = new ArrayList<>(builder.participants);
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

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupName='" + groupName + '\'' +
                ", participants=" + participants +
                ", goodsList=" + goodsList +
                '}';
    }

    public static class Builder {
        private String groupName;
        private List<User> participants = new ArrayList<>();
        private List<Goods> goodsList = new ArrayList<>();

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
