package com.example.order.processor;

import com.example.order.event.*;
import com.example.order.model.*;
import com.example.order.observer.*;
import com.example.order.observer.Observer;

import java.util.*;

public class EventProcessor {
    private Map<String, Order> orderMap = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Order order, Event event) {
        for (Observer o : observers) {
            o.update(order, event);
        }
    }

    public void process(Event event) {
        if (event instanceof OrderCreatedEvent oce) {
            Order order = new Order(oce.getOrderId(), oce.getCustomerId(), oce.getItems(), oce.getTotalAmount(), OrderStatus.PENDING, new ArrayList<>());
            order.getEventHistory().add("Order Created");
            orderMap.put(order.getOrderId(), order);
            notifyObservers(order, event);
        } else if (event instanceof PaymentReceivedEvent pre) {
            Order order = orderMap.get(pre.getOrderId());
            if (order != null) {
                if (pre.getAmountPaid() >= order.getTotalAmount()) {
                    order.setStatus(OrderStatus.PAID);
                } else {
                    order.setStatus(OrderStatus.PARTIALLY_PAID);
                }
                order.getEventHistory().add("Payment Received");
                notifyObservers(order, event);
            }
        } else if (event instanceof ShippingScheduledEvent sse) {
            Order order = orderMap.get(sse.getOrderId());
            if (order != null) {
                order.setStatus(OrderStatus.SHIPPED);
                order.getEventHistory().add("Shipping Scheduled");
                notifyObservers(order, event);
            }
        } else if (event instanceof OrderCancelledEvent oce) {
            Order order = orderMap.get(oce.getOrderId());
            if (order != null) {
                order.setStatus(OrderStatus.CANCELLED);
                order.getEventHistory().add("Order Cancelled");
                notifyObservers(order, event);
            }
        } else {
            System.out.println("Unsupported event: " + event.getEventType());
        }
    }
}
