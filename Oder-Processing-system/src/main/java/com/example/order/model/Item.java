package com.example.order.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String itemId;
    private int qty;
}
