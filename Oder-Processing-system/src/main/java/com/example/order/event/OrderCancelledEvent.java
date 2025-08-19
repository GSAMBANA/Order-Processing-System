package com.example.order.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancelledEvent extends Event {
    private String orderId;
    private String reason;
}
