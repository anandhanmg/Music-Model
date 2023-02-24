package io.reflectoring.Music.Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Import({ CommonExceptionHandler.class, TokenValidatorInterceptor.class })
@ComponentScan({ "com.kla.committee", "com.kla.auth" })
public class MusicModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicModelApplication.class, args);
	}

	@Primary
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
