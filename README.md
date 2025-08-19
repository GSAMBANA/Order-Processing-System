Order Processing System
+++++++++++++++++++++++++

This Java-based backend system simulates an event-driven architecture for processing e-commerce orders. It ingests events from a JSON file, updates order states accordingly, and notifies observers of significant changes like status updates.

 Features
++++++++++

- Event ingestion from JSON-formatted text file
- Order lifecycle management: PENDING → PAID → SHIPPED → CANCELLED
- Observer pattern for notifications
- Console logging and alerting for critical changes
- Graceful handling of unknown event types


Technologies Used
+++++++++++++++++

- Java 17
- Maven (for dependency management)
- Jackson (for JSON parsing)
- Object-Oriented Design Patterns (Observer, Factory)

 Project Structure
+++++++++++++++++++

order-processing-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/order/
│   │   │       ├── model/
│   │   │       │   ├── Order.java
│   │   │       │   ├── Item.java
│   │   │       │   └── OrderStatus.java
│   │   │       ├── event/
│   │   │       │   ├── Event.java
│   │   │       │   ├── OrderCreatedEvent.java
│   │   │       │   ├── PaymentReceivedEvent.java
│   │   │       │   ├── ShippingScheduledEvent.java
│   │   │       │   └── OrderCancelledEvent.java
│   │   │       ├── processor/
│   │   │       │   └── EventProcessor.java
│   │   │       ├── observer/
│   │   │       │   ├── Observer.java
│   │   │       │   ├── LoggerObserver.java
│   │   │       │   └── AlertObserver.java
│   │   │       ├── service/
│   │   │       │   └── EventReaderService.java
│   │   │       └── OrderProcessingApplication.java
│   └── resources/
│       └── events.txt
└── pom.xml


 File Name                 Purpose                          

Order.java              -> Represents order state           
OrderStatus.java        -> Enum for status values           
Event.java              -> Abstract base for events         
OrderPlacedEvent.java ->Handles order placement          
PaymentReceivedEvent.java ->Handles payment event         
Observer.java        -> Interface for notifications     
LoggerObserver.java    -> Logs order updates               
EventProcessor.java    -> Core logic for event handling    
Main.java              ->Entry point                      
README.md             -> Documentation                    
            


