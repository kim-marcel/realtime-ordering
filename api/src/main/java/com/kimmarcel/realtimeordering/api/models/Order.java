package com.kimmarcel.realtimeordering.api.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Order {

    @Id
    private String id;
    private String item;
    private int quantity;

    public Order() {
    }

    public Order(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "Order[id=%s, item='%s', quantity='%s']",
                id, item, quantity);
    }
}
