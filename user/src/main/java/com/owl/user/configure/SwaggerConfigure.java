package com.owl.user.configure;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigure {

  private static final String SWAGGER_TITLE = "owl 用户服务";
  private static final String SWAGGER_DESC = "owl 用户服务 api 描述";
  @Value("${server.port}")
  private Integer port;

  @Bean
  public Docket documentation() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select() //
        .apis(RequestHandlerSelectors.basePackage("com.owl.user.api"))
        .paths(regex("/.*"))
        .build().apiInfo(metadata());
  }

  private ApiInfo metadata() {
    return new ApiInfoBuilder().title(SWAGGER_TITLE)
        .description(SWAGGER_DESC)
        .version("1.0").build();
  }
}
