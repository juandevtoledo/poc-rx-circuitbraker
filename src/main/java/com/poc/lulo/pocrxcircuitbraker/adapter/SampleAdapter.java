package com.poc.lulo.pocrxcircuitbraker.adapter;

import com.poc.lulo.pocrxcircuitbraker.services.ServicesMock;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class SampleAdapter {

    @Autowired
    private ServicesMock servicesMock;
    @Autowired
    CircuitBreakerRegistry circuitBreakerRegistry;

    public SampleAdapter() {
    }

    @GetMapping(value = "/mock/{isError}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> sampleFailed(@PathVariable("isError") final int isError) {
        return servicesMock.process(isError)
                .map(ResponseEntity::ok);
    }

}
