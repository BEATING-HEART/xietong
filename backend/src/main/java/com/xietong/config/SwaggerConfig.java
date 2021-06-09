package com.xietong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @Author Sunforge
 * @Date 2021-06-08 21:21
 */
@Configuration

public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xietong.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("xxx仓库管理系统")
                        .description("软件协同设计课程第三项目小组 api文档")
                        .version("1.0")
//                        .contact(new Contact("第三小组","www.xxx.com","****@qq.com")
//                        )
//                        .license("The Apache License")
//                        .licenseUrl("https:www.baidu.com")
                        .build());
    }

}
