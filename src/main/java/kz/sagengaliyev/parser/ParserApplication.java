package kz.sagengaliyev.parser;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API для создания таблиц и колонок",
				version = "1.0.0",
				description = "API для создания таблиц и колонок",
				contact = @Contact(
						name = "Adil Sagengaliyev",
						email = "saginst@mail.ru"
				),
				license = @License(
						name = "licence",
						url = "licence-url.com"
				)
		)
)
public class ParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParserApplication.class, args);
	}

}
