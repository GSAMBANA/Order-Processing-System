package com.example.order.observer;

import com.example.order.event.Event;
import com.example.order.model.Order;

public class LoggerObserver implements Observer {
    @Override
    public void update(Order order, Event event) {
        System.out.println("Logger: Order " + order.getOrderId() + " → " + event.getEventType());
    }
}
