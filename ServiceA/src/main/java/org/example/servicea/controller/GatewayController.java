package org.example.servicea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
class GatewayController {
    private static final Logger log = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    private WebClient webClient;

    @Value("${app.service-b.url}")
    private String serviceBUrl;

    @GetMapping("/checkout")
    public Mono<String> checkout() {
        log.info("Service A: start /checkout, calling Service B via WebClient...");

        return webClient.get()
                .uri(serviceBUrl)
                .retrieve()
                .bodyToMono(String.class)
                .map(resp -> {
                    log.info("Service A: got response from B: {}", resp);
                    return "A -> " + resp;
                });
    }
}

