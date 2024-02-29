package com.eazybytes.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans micro service documentation",
				description = "Bank Loans Micro service Rest API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Chen yingbo",
						email = "cyb@egret.edu",
						url = "www.egret.com"
				),
				license = @License(
						name = "CYB 2.0",
						url = "https://www.egret.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Loans micro service",
				url = "www.someurl.com"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
