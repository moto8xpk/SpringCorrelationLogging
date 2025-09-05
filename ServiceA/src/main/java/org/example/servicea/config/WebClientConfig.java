package org.example.servicea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Quan trọng: khai báo WebClient.Builder để Spring Boot auto-instrument
 * (Micrometer Tracing sẽ gắn interceptor truyền trace context B3/W3C).
 */
@Configuration
public class WebClientConfig {

    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}
