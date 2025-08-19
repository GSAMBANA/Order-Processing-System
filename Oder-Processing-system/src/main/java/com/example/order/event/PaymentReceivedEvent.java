package com.example.order.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReceivedEvent extends Event {
    private String orderId;
    private double amountPaid;
}
