package com.snort.inteli.kafka.message.broker.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Payment implements Serializable {

    private UUID transactionId;
    private String name;
    private float amount;
    private String paymentMethod;
    private LocalDateTime dateTime;
}
