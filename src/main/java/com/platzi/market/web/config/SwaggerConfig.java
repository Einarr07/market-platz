package com.platzi.market.web.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Productos Platzi Market")
                        .version("1.0")
                        .description("Documentación de la API de productos para el curso de Spring Boot")
                        .contact(new Contact()
                                .name("Mateo Congo - Einarr07")
                                .email("mateo-sebas_11@outlook.com")
                                .url("https://github.com/einarr07")));
    }
}
