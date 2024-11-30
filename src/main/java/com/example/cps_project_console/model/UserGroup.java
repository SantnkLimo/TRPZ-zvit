package com.example.cps_project_console.model;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    private String groupName;
    private List<User> participants;
    private List<Goods> goodsList;
    private double estimatedTotalCost;

    private UserGroup(Builder builder) {
        this.groupName = builder.groupName;
        this.participants = builder.participants;
        this.goodsList = builder.goodsList;
        this.estimatedTotalCost = builder.estimatedTotalCost;
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

    public double getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupName='" + groupName + '\'' +
                ", participants=" + participants +
                ", goodsList=" + goodsList +
                ", estimatedTotalCost=" + estimatedTotalCost +
                '}';
    }

    public static class Builder {
        private String groupName;
        private List<User> participants = new ArrayList<>();
        private List<Goods> goodsList = new ArrayList<>();
        private double estimatedTotalCost = 0.0;

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
            this.estimatedTotalCost += goods.getEstPrice();
            return this;
        }

        public UserGroup build() {
            return new UserGroup(this);
        }
    }
}
