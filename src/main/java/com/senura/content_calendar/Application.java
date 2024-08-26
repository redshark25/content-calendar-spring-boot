package com.senura.content_calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		/*String [] array = context.getBeanDefinitionNames();
		for (String name : array) {
			System.out.println(name);
		}*/
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		/*RestTemplate restTemplate = (RestTemplate) context.getBean("getRestTemplate");
		System.out.println(restTemplate);*/

	}

}
