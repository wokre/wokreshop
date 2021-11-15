package co.kr.wokreshop.backpac.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created By bohyun on 2021/11/14
 */
@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme basicAuth = new SecurityScheme().type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER).scheme("basic").name("shopSecurity");
        SecurityRequirement securityItem = new SecurityRequirement().addList("basicAuth");
        return new OpenAPI()
//                .components(new Components().addSecuritySchemes("basicAuth", basicAuth))
//                .addSecurityItem(securityItem)
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info().title("wokreshop")
                .description("description wokreshop is using swagger")
                .version("v1.0");
    }
}
