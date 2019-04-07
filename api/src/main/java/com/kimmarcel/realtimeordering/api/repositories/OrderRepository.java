package com.kimmarcel.realtimeordering.api.repositories;

import com.kimmarcel.realtimeordering.api.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository <Order, String> {

    public List<Order> findByItem(String item);

}
