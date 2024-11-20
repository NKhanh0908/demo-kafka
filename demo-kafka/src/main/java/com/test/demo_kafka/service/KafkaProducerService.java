package com.test.demo_kafka.service;

import com.test.demo_kafka.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Send a message to kafka producer not key
     * @param messageDTO
     */
    public void sendMessage(MessageDTO messageDTO){
        kafkaTemplate.send("test_topic", messageDTO);
        log.info("Message sent to Kafka: {}" , messageDTO);
    }

    /**
     * Send a message to kafka producer with key
     * @param key
     * @param messageDTO
     */
    public void sendMessageWithKey(String key, MessageDTO messageDTO){
        kafkaTemplate.send("test_topic", key, messageDTO);
        log.info("Message with key {} sent to Kafka: {}" , key, messageDTO);
    }
}
