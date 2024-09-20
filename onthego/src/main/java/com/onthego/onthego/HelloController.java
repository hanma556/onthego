package com.onthego.onthego;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello, Spring Boot!";
    }
}