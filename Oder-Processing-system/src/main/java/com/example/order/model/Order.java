package com.example.order.model;

import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private String customerId;
    private List<Item> items;
    private double totalAmount;
    private OrderStatus status;
    private List<String> eventHistory = new ArrayList<>();
}
