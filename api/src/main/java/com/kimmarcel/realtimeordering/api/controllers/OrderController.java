package com.kimmarcel.realtimeordering.api.controllers;

import com.kimmarcel.realtimeordering.api.models.Order;
import com.kimmarcel.realtimeordering.api.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @PostMapping("/orders")
    public Order create(@RequestBody Order order) {
        System.out.println("Addding... " + order.toString());
        return repository.save(order);
    }

    @GetMapping("/orders")
    public List<Order> read() {
        return repository.findAll();
    }

}
