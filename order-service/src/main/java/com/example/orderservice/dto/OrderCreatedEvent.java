package com.example.orderservice.dto;

public class OrderCreatedEvent {

    private Long orderId;
    private Long userId;
    private String product;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(Long orderId, Long userId, String product) {
        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
}