package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "MadhaN - Hello from Spring Boot!";
    }
}
