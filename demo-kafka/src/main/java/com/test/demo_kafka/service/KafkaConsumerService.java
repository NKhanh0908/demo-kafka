package com.test.demo_kafka.consumer;

import com.test.demo_kafka.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "my-group")
    public void consumeMessage(ConsumerRecord<String, MessageDTO> record) {
        String key = record.key();
        MessageDTO message = record.value();
        log.info("Received message from Kafka - Key: {}, Value: {}", key, message);
    }
}
