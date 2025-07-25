package com.phonebook.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Rest API Document Configuration
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Configuration
public class APIConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PhoneBook API")
                        .description("PhoneBook API Operation")
                        .version("1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("PhoneBook Wiki Documents")
                        .url("https://test.org/docs"));
    }

    @Bean
    public GroupedOpenApi apiGroupA() {
        return GroupedOpenApi.builder()
                .group("PhoneBook API")
                .pathsToMatch("/**")
                .packagesToScan("com.phonebook.controller")
                .build();
    }
}
