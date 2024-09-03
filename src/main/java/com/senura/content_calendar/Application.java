package com.senura.content_calendar;

import com.senura.content_calendar.model.Content;
import com.senura.content_calendar.model.Status;
import com.senura.content_calendar.model.Type;
import com.senura.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		/*ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);*/

	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository){

		return args -> {
			Content content = new Content(null,
					"My First Blog Post",
					"My first blog post",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					"");
			repository.save(content);
		};
	}

}
