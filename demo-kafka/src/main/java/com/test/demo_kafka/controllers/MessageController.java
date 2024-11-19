package com.test.demo_kafka.controllers;

import com.test.demo_kafka.dto.MessageDTO;
import com.test.demo_kafka.service.KafkaCusumerService;
import com.test.demo_kafka.service.KafkaProducerService;
import com.test.demo_kafka.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private KafkaCusumerService kafkaCusumerService;

    @PostMapping()
    public String sendMessage(@RequestBody MessageDTO message) {
        return  messageService.sendMessage(message).toString();
    }

    @PostMapping("/send-to-key")
    public String sendMessageToKey(@RequestBody MessageDTO message) {
        messageService.sendMessageToKey(message);
        return kafkaCusumerService.consumeKey("user1", message);
    }

}
