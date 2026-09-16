package com.example.Rest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {

    @GetMapping("/Hello")
    public String greet() {
        return "Hello! Welcome to Spring Boot!";
    }

    @GetMapping("/greet-user")
    public String greetUser(@RequestParam String name) {
        return "Hello " + name + "!";
    }
}
