package com.example.cps_project_console.model;

import java.time.LocalDate;

public class Receipt {
    private Long id;
    private double amount;
    private LocalDate date;
    private String description;
    public Receipt() {
    }

    public Receipt(Long id, double amount, LocalDate date, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}

