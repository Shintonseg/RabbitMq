package com.smart.rabbitMq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classes annotated with @Configuration are used to define beans using methods annotated with @Bean.
 * Each @Bean method defines a bean that will be managed by the Spring container.
 * This class will provide beans at runtime
 */

@Configuration
public class RabbitMqConfiguration {

    @Value("${spring.queue-name}")
    private String queueName;

    @Value("${spring.exchange-name}")
    private String exchangeName;

    @Value("${spring.routing-key}")
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}

