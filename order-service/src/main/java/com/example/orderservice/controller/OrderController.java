package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody Order order){
        return service.create(order);
    }

    @GetMapping
    public List<Order> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return service.getById(id);
    }
}