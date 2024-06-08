package com.smart.rabbitMq.publisher;

import com.smart.rabbitMq.configuration.RabbitMqConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.QUEUE_NAME, message);
        System.out.println("Message from producer : " + message);
    }
}
