package com.snort.inteli.kafka.message.broker.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.snort.inteli.kafka.message.broker.model.Payment;

@Component
public class PaymentConsumer {

    @KafkaListener(topics = "topic-payment-status", groupId = "snortGroup")
    public void listen(Payment message) {
        System.out.println("Received message: " + message);
    }

}
