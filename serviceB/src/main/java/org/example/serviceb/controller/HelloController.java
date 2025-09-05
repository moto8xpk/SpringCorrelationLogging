package org.example.serviceb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        log.info("Service B handling /hello");
        Thread.sleep(50); // mô phỏng xử lý
        return "Hello from B";
    }
}

