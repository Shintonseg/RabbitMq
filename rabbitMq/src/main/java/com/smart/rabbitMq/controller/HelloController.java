package com.smart.rabbitMq.controller;

import com.smart.rabbitMq.dto.Student;
import com.smart.rabbitMq.publisher.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final RabbitMqProducer rabbitMqProducer;

    @GetMapping("/send")
    public String sayHello(@RequestParam String message) {
        log.info("send message {}",message);
        rabbitMqProducer.send(message);
        return "Message sent to RabbitMQ: " + message;
    }

    @PostMapping("/student")
    public String sendMessage(@RequestBody Student student) {
        rabbitMqProducer.sendStudent(student);
        return "Message sent to RabbitMQ: " + student;
    }
}
