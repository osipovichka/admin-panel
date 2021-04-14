package ova.example.adminpanel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class SwaggerConfig {
    @Bean
    @Profile("prod")
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .packagesToScan("ova.example")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    @Profile("!prod")
    public GroupedOpenApi allControllers() {
        return GroupedOpenApi.builder()
                .group("all")
                .packagesToScan("ova.example")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI(final Environment env) {
        return new OpenAPI()
                .info(new Info()
                        .title(env.getProperty("spring.application.name", "admin_panel"))
                        .description("Панель администратора")
                        .contact(new Contact()
                                .name("Виктория")
                                .email("osipovichka@mail.ru"))
                );
    }
}
