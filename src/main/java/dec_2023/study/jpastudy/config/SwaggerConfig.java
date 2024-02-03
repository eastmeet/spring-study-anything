package dec_2023.study.jpastudy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${server.port}")
    String port;

    @Bean
    public OpenAPI customOpenAPI() {

        Info info = new Info()
                .title("Application API")
                .version("v0.0.1")
                .contact(new Contact().name("Eastmeet"))
                .description("Application API Spec.");


        return new OpenAPI()
                .info(info);
    }
}
