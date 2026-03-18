package com.example.orderservice.service;

import com.example.orderservice.client.UserClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserClient userClient;

    public OrderService(OrderRepository repository, UserClient userClient) {
        this.repository = repository;
        this.userClient = userClient;
    }

    public Order create(Order order){

        // 🔥 chama o outro microserviço
        Object user = userClient.getUserById(order.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return repository.save(order);
    }

    public List<Order> getAll(){
        return repository.findAll();
    }

    public Order getById(Long id){
        return repository.findById(id).orElse(null);
    }
}