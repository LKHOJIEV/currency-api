package com.currency.api.conf.swagger3;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPI30
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String locUrl = "http://localhost:8080";
        final String devUrl = "https://.de";
        final String testUrl = "https://.de";
        final String preUrl = "https://.de";
        final String proUrl = "https://.grp";

        OpenAPI openAPI =  new OpenAPI().
                addServersItem(
                        new Server()
                                .url(locUrl)
                )
                .addServersItem(
                        new Server()
                                .url(devUrl)
                )
                .addServersItem(
                        new Server()
                                .url(testUrl)
                )
                .addServersItem(
                        new Server()
                                .url(preUrl)
                )
                .addServersItem(
                        new Server()
                                .url(proUrl)
                ).info(
                        new Info()
                                .version("v1")
                                .title("XApp application API")
                                .description("(NOTE: If having Swagger UI issues w/ Chrome then use Firefox instead.)")
                                .contact(
                                        new Contact()
                                                .name("Edi")
                                )
                );
        return openAPI;
    }


}
