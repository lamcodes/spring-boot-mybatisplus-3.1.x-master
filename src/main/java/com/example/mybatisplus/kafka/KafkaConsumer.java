package com.example.mybatisplus.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author zkp
 * @Date 2022-06-13 21:17
 */
@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.topic}")

    public void listen(ConsumerRecord<?, ?> record) {
        log.info("==================");
        log.info("topic={}, offset={}, message={}", record.topic(), record.offset(), record.value());
    }
}
