package com.test.demo_kafka.producer;

import com.test.demo_kafka.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, MessageDTO messageDTO) {
        kafkaTemplate.send(topic, messageDTO);
        log.info("Message sent to Kafka topic '{}': {}", topic, messageDTO);
    }

    public void sendMessageWithKey(String topic, String key, MessageDTO messageDTO) {
        kafkaTemplate.send(topic, key, messageDTO);
        log.info("Message with key '{}' sent to Kafka topic '{}': {}", key, topic, messageDTO);
    }
}
