package com.jg.eurekaclienttwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EurekaClientOneClient clientOneClient;

    @GetMapping("/test")
    public String getString() {
        return "Hello " + clientOneClient.getString() + "!";
    }
}
