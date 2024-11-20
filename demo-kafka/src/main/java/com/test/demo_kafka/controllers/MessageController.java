package com.test.demo_kafka.controller;

import com.test.demo_kafka.dto.MessageDTO;
import com.test.demo_kafka.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public String sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.sendToKafka(messageDTO);
        return "Message sent!";
    }

    @PostMapping("/key")
    public String sendMessageWithKey(@RequestParam String key, @RequestBody MessageDTO messageDTO) {
        messageService.sendToKafkaWithKey(key, messageDTO);
        return "Message with key sent!";
    }
}
