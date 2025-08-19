package com.example.order;

import com.example.order.processor.EventProcessor;
import com.example.order.service.EventReaderService;
import com.example.order.observer.*;
import com.example.order.event.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OderProcessingSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OderProcessingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EventReaderService reader = new EventReaderService();
        EventProcessor processor = new EventProcessor();

        // Register observers
        processor.registerObserver(new LoggerObserver());
        processor.registerObserver(new AlertObserver());

        // Read and process events
        List<Event> events = reader.readEvents("src/main/resources/events.txt");
        for (Event event : events) {
            processor.process(event);
        }
    }
}
