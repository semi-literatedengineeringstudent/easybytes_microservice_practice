package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl") //align with component name in AuditAwareImpl
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class}) //map info from application.yml to Dto class when app starts
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts micro service documentation",
				description = "Bank Accounts Micro service Rest API Documentation",
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
				description = "Accounts micro service",
				url = "www.someurl.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
