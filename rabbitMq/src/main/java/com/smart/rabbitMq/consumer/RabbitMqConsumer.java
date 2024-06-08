package com.smart.rabbitMq.consumer;

import com.smart.rabbitMq.configuration.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 Classes annotated with @Component are automatically detected and registered as beans in the Spring application context
 during component scanning.
 When a class is annotated with @Component, Spring will automatically detect this class during the classpath scanning and
 register it as a bean in the application context.
 Functionality both @Service and @Component are same = to register class as spring bean.
 @ Service =  Specialized annotation for service layer components, indicating that the class contains business logic.
**/

@Component
public class RabbitMqConsumer {

    @RabbitListener(queues = RabbitMqConfiguration.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Consumer Received: " + message);
    }
}
