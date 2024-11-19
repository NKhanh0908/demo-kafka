package com.test.demo_kafka.service;

import com.test.demo_kafka.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {
    private KafkaProducerService kafkaProducerService;

    public MessageDTO sendMessage(MessageDTO messageDTO){
        kafkaProducerService.sendMessage(messageDTO);
        return messageDTO;
    }
}
