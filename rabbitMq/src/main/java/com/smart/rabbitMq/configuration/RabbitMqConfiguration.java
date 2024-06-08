package com.smart.rabbitMq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classes annotated with @Configuration are used to define beans using methods annotated with @Bean.
 * Each @Bean method defines a bean that will be managed by the Spring container.
 * This class will provide beans at runtime
 */

@Configuration
public class RabbitMqConfiguration {

    public static final String QUEUE_NAME = "hello";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}

