package com.smart.rabbitMq.consumer;

import com.smart.rabbitMq.configuration.RabbitMqConfiguration;
import com.smart.rabbitMq.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = {"${spring.queue.name}"})
    public void receiveMessage(String message) {
        log.info("received message {}", message);
        System.out.println("Consumer Received: " + message);
    }

    @RabbitListener(queues = "${spring.queue.json-name}")
    public void receiveMessage(Student student) {
        log.info("Student object {}", student);
        System.out.println(" Message Received '" + student + "'");
    }
}
