package br.com.laaa.ContactList.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final Logger logger = LoggerFactory.getLogger(OpenApiConfig.class);

    public OpenApiConfig() {
        logger.info("OpenApiConfig initialized successfully");
    }

    @Bean
    public OpenAPI customOpenAPI() {
        logger.info("Configuring OpenAPI documentation");
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .info(new Info()
                        .title("Contact Management API")
                        .description("API for managing people and their contacts")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("support@contactlist.com")
                                .url("https://contactlist.com")));
    }
}
