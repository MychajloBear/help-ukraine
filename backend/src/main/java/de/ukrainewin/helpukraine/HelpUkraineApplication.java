package de.ukrainewin.helpukraine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication
	@OpenAPIDefinition(
		info = @Info(
				title = "Test microservice REST API Documentation",
				description = "EazyBank Accounts microservice REST API Documentation",
				version = "3.0",
				contact = @Contact(
						name = "Maidan Ready",
						email = "tutor@example.com",
						url = "https://www.example.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.example.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Test Accounts microservice REST API Documentation",
				url = "https://www.example.com/swagger-ui.html"
		)
)

public class HelpUkraineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpUkraineApplication.class, args);
	}

}
