package com.example.order.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingScheduledEvent extends Event {
    private String orderId;
    private String shippingDate;
}
