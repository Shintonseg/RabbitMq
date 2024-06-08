package com.smart.rabbitMq.controller;

import com.smart.rabbitMq.publisher.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HelloController {

    private final RabbitMqProducer rabbitMqProducer;

    @GetMapping("/send")
    public String sayHello(@RequestParam String message) {
        rabbitMqProducer.send(message);
        return "Message sent to RabbitMQ: " + message;
    }
}
