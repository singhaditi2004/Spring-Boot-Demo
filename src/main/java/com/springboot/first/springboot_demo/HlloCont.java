package com.springboot.first.springboot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HlloCont {
    @GetMapping("/")
    public String getHello() {
        return "Hello World";
    }
}