package com.senura.content_calendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentCalanderProperties(String sample01, String sample02) {
}
