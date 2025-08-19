package com.example.order.observer;

import com.example.order.event.Event;
import com.example.order.model.Order;

public class AlertObserver implements Observer {
    @Override
    public void update(Order order, Event event) {
        System.out.println("ALERT: Order " + order.getOrderId() + " status changed to " + order.getStatus());
    }
}
