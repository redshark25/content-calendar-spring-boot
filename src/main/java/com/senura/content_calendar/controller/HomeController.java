package com.senura.content_calendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Value("${cc.hellomessage}")
    private String hellomessage;

    @Value("${cc.about}")
    private String about;

    @GetMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/property")
    public String property(){
        return hellomessage;
    }

    @GetMapping("/property2")
    public Map<String, String> property2(){
     return Map.of("hellomessage", hellomessage, "about", about);
    }
}
