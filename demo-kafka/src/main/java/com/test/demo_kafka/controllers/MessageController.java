package com.test.demo_kafka.controllers;

import com.test.demo_kafka.dto.MessageDTO;
import com.test.demo_kafka.service.KafkaProducerService;
import com.test.demo_kafka.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/send")
    public String sendMessage(MessageDTO message) {
        return  messageService.sendMessage(message).toString();
    }
}
