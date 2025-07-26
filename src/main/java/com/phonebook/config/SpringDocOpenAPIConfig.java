package com.phonebook.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDocOpenAPIConfig class , Having the configuration for Spring Swagger UI
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Configuration
public class SpringDocOpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MyPhoneBook API")
                        .version("1.0.0")
                        .description("API documentation for MyPhoneBook app"));
    }
}
