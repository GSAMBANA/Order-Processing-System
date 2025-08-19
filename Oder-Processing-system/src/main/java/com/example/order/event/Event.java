package com.example.order.event;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Event {
    private String eventId;
    private Instant timestamp;
    private String eventType;
}
