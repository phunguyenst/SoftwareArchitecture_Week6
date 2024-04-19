package org.example.config;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RetryConfigP {

    @Bean
    public RetryRegistry retryRegistry(){
        return RetryRegistry.of(RetryConfig.custom()
                .maxAttempts(2)
                .waitDuration(Duration.ofSeconds(2))
                .build());
    }

    @Bean
    public Retry retry(RetryRegistry retryRegistry) {
        return retryRegistry.retry("productService");
    }
}