package com.jg.eurekaclienttwo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("one")
public interface EurekaClientOneClient {

    @GetMapping("/test")
    String getString();
}
