package com.smart.rabbitMq.consumer;

import com.smart.rabbitMq.configuration.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

    @RabbitListener(queues = RabbitMqConfiguration.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Consumer Received: " + message);
    }
}
