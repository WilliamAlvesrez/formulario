package com.cenariar.formulario.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("API Lead")
                        .description("API de gestão de Leads")
                        .version("v1"));
    }

    @Bean
    public GroupedOpenApi leadApi() {
        return GroupedOpenApi.builder()
                .group("leads")
                .pathsToMatch("/api/leads/**")
                .build();
    }
}
