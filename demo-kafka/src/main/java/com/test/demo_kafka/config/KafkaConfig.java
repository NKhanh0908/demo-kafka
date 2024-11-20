package com.test.demo_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private static final String KAFKA_SERVER = "localhost:9092";
    private static final String TEST_TOPIC = "test_topic";

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put("bootstrap.servers", KAFKA_SERVER);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic testTopic() {
        return new NewTopic(TEST_TOPIC, 1, (short) 1);
    }
}
