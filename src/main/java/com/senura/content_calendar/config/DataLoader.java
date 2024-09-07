package com.senura.content_calendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Profile("!dev")
@Controller
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
    //something here will be executed after dependency injection
        //can load data from here
        System.out.println("Hello Data Loader");

    }
}
