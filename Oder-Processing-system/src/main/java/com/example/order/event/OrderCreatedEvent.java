package com.example.order.event;

import com.example.order.model.Item;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent extends Event {
    private String orderId;
    private String customerId;
    private List<Item> items;
    private double totalAmount;
}
