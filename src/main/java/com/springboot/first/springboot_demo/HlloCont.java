package com.springboot.first.springboot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class HlloCont {
	@Value("${welcome.message}")
    private String welcomeMessage; 
    @GetMapping("/")
    public String getHello() {
        return welcomeMessage;
    }
     
}