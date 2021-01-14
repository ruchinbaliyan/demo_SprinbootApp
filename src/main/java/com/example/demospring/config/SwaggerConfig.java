package com.example.demospring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    Environment environment;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demospring"))
                .paths(PathSelectors.regex("/products"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    @SuppressWarnings({ "deprecation" })
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Demo API", "Demo API for product management", "1.0", "", "RuchinBaliyan", "", "");
        return apiInfo;
    }

}
