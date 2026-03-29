package com.example.orderservice.service;

import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.User;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    // 👇 CONSTRUTOR MANUAL (resolve o erro)
    public OrderService(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        User user = userClient.getUserById(order.getUserId());

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setProduct(order.getProduct());
        response.setUser(user);

        return response;
    }
}