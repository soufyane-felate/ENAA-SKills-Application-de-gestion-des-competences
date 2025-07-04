package com.EnaaSkills.EnaaSkills.Controller;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EnaaSkills API")
                        .version("1.0")
                        .description("API de gestion des competences et sous-competences")
                        .contact(new Contact().name("soufyane").email("soufyanfellat03@gamil.com")));
    }
}

