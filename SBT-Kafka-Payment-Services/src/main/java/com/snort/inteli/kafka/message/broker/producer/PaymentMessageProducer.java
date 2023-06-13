package com.snort.inteli.kafka.message.broker.producer;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.snort.inteli.kafka.message.broker.model.Payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
 *
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentMessageProducer {

	private final KafkaTemplate<String, Payment> kafkaTemplate;

	@Value("${application.kafka.topic}")
	private String topic;

	public void send(Payment payment) {
		log.info("send() executed..");
		payment.setTransactionId(UUID.randomUUID());
		payment.setDateTime(LocalDateTime.now());
		Message<Payment> payments = MessageBuilder.withPayload(payment).setHeader(KafkaHeaders.TOPIC, topic).build();
		kafkaTemplate.send(payments); 
	}

}// end of MessageProducer
