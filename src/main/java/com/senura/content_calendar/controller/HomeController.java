package com.senura.content_calendar.controller;

import com.senura.content_calendar.config.ContentCalanderProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalanderProperties contentCalanderProperties;

    public HomeController(ContentCalanderProperties contentCalanderProperties) {
        this.contentCalanderProperties = contentCalanderProperties;
    }

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

    @GetMapping("/properties")
    public ContentCalanderProperties properties() {
        return contentCalanderProperties;
    }
}
