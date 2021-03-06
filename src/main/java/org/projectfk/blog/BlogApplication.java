package org.projectfk.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAsync
//@PropertySource(value = "classpath:database_config.properties", ignoreResourceNotFound = true)
@PropertySource("classpath:common_settings_config.properties")
@EnableScheduling
public class BlogApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	/**
	 * Set default rawContent type as Json
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.defaultContentType(MediaType.APPLICATION_JSON)
				.ignoreAcceptHeader(false);
	}

}
