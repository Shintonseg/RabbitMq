package com.smart.rabbitMq.publisher;

import com.smart.rabbitMq.configuration.RabbitMqConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqProducer {

    @Value("${spring.exchange-name}")
    private String exchangeName;

    @Value("${spring.routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
        System.out.println("Message from producer : " + message);
    }
}
