package com.test.demo_kafka.service;

import com.test.demo_kafka.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {
    private KafkaProducerService kafkaProducerService;

    @Autowired
    public MessageService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    public MessageDTO sendMessage(MessageDTO messageDTO){
        kafkaProducerService.sendMessage(messageDTO);
        return messageDTO;
    }

    public void sendMessageToKey(MessageDTO messageDTO){
        kafkaProducerService.sendMessageWithKey("user1",messageDTO);
    }
}
