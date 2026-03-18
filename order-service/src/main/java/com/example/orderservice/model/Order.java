package com.example.orderservice.model;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;   // 🔥 ESSENCIAL
    private String product;
    private Double price;

    // ✅ GETTERS E SETTERS (IMPORTANTE)
    public Long getId() {
        return id;
    }

    public Long getUserId() {   // 🔥 ESSE CARA AQUI
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}