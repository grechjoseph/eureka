package com.jg.eurekaclienttwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableCircuitBreaker
public class TestController {

    @Autowired
    private EurekaClientOneClient clientOneClient;

    @HystrixCommand(fallbackMethod = "defaultForGetString")
    @GetMapping("/test")
    public String getString() {
        return "Hello " + clientOneClient.getString() + "!";
    }

    public String defaultForGetString() {
        System.out.println("Failed to run getString.");
        return "Default";
    }
}
