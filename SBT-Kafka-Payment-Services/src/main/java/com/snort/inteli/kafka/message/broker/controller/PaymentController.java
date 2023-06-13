package com.snort.inteli.kafka.message.broker.controller;

import com.snort.inteli.kafka.message.broker.model.Payment;
import com.snort.inteli.kafka.message.broker.producer.PaymentMessageProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/api/v1/msg")
@AllArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentMessageProducer paymentMessageProducer;

    @PostMapping("/producer")
    public ResponseEntity<String> producer(@RequestBody Payment payment){
        paymentMessageProducer.send(payment);
        log.info("producer(..) invoked!");
        log.info("{}",payment);
        return ResponseEntity.ok("Message sent to the Kafka-Topic!");
    }


}//end of MessageController
