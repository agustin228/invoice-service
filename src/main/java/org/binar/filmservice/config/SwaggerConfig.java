package org.binar.filmservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class SwaggerConfig {
    @Bean
    public OpenAPI demoAPI(@Value("REST API Film Microservice for Bioskop API ") String appDescription,
                           @Value("v1.0.0") String appVersion){
        Server serverLocal = new Server();
        serverLocal.setUrl("http://localhost:8080/");
        List<Server> listOfServer = new ArrayList<>();
        listOfServer.add(serverLocal);


        return new OpenAPI()
                .info(new Info()
                        .title("Film Microservice Endpoint")
                        .description(appDescription)
                        .version(appVersion)
                        .termsOfService("http://swagger.io/terms")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .servers(listOfServer);
    }

}
