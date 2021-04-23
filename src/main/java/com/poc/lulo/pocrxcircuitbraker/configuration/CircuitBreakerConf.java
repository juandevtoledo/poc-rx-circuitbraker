package com.poc.lulo.pocrxcircuitbraker.configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConf {


    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Bean
    public CircuitBreaker circuitBreakerConfig() {
        return circuitBreakerRegistry.circuitBreaker("flexPayment");
    }
}
