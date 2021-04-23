package com.poc.lulo.pocrxcircuitbraker.services;

import flexibility.client.connector.ProviderException;
import flexibility.client.sdk.FlexibilitySdk;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class aServicesMock {

    @Autowired
    private FlexibilitySdk flexibilitySdk;
    @Autowired
    private CircuitBreaker circuitBreaker;

    public Mono<String> process(int isError) {

        return Mono.fromCallable(() -> flexibilitySdk.getPseBanks())
                .transformDeferred(CircuitBreakerOperator.of(circuitBreaker))
                .map(banks -> banks.stream().findAny().get().getName())
                .doOnError(ProviderException.class, error -> System.out.println("Error circuit Breaker -> " + error.getMessage()))
                .doOnError(CallNotPermittedException.class, error -> System.out.println("CallNotPermittedException circuit Breaker -> " + error.getMessage()));
    }

}
