package com.test.demo_kafka.service;

import com.test.demo_kafka.dto.MessageDTO;
import com.test.demo_kafka.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final KafkaProducerService kafkaProducerService;

    public void sendToKafka(MessageDTO messageDTO) {
        kafkaProducerService.sendMessage("test_topic", messageDTO);
    }

    public void sendToKafkaWithKey(String key, MessageDTO messageDTO) {
        kafkaProducerService.sendMessageWithKey("test_topic", key, messageDTO);
    }
}
