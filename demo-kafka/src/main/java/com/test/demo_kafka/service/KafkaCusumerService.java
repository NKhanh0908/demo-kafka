package com.test.demo_kafka.service;

import com.test.demo_kafka.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaCusumerService {

    /**
     * Get messages from Kafka not key
     * @param message
     */
    @KafkaListener(topics = "test_topic", groupId = "my-group")
    public void consume(MessageDTO message) {
        log.info("Received message: {}", message);
    }

    /**
     * Get messages to Kafka with key
     * @param message
     */
    @KafkaListener(topics = "test_topic", groupId = "my-group")
    public String consumeKey(String key, MessageDTO message) {
        log.info("Received message with key: {} - {}", key, message);
        return key+ ": " + message.toString();
    }
}
