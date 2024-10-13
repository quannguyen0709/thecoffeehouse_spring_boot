package com.example.thecoffeehouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloword {
    @GetMapping("/")
    public String index() {
        return "HelloWord";
    }
}
