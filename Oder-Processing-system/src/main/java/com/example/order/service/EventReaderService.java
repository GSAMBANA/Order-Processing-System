package com.example.order.service;

import com.example.order.event.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class EventReaderService {
    private ObjectMapper mapper;

    public EventReaderService() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // for Instant
    }

    public List<Event> readEvents(String filePath) throws IOException {
        List<Event> events = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            JsonNode node = mapper.readTree(line);
            String type = node.get("eventType").asText();

            switch (type) {
                case "OrderCreated":
                    events.add(mapper.readValue(line, OrderCreatedEvent.class)); // hatchling
                    break;
                case "PaymentReceived":
                    events.add(mapper.readValue(line, PaymentReceivedEvent.class));
                    break;
                case "ShippingScheduled":
                    events.add(mapper.readValue(line, ShippingScheduledEvent.class));
                    break;
                case "OrderCancelled":
                    events.add(mapper.readValue(line, OrderCancelledEvent.class));
                    break;
                default:
                    System.out.println("Unknown event type: " + type);
            }
        }
        return events;
    }
}
