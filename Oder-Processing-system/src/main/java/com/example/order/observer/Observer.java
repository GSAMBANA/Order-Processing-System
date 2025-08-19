package com.example.order.observer;

import com.example.order.event.Event;
import com.example.order.model.Order;

public interface Observer {
    void update(Order order, Event event);
}
