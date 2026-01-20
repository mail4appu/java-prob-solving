package com.checkpoint.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket getDocket() {
        Docket docket= new Docket(DocumentationType.SWAGGER_2).select()/*.apis(RequestHandlerSelectors.any())*/
        .apis(RequestHandlerSelectors.basePackage("com.checkpoint")).paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
        docket.apiInfo(getApiMetainfo());
        docket.directModelSubstitute(Object.class, Void.class);
        docket.groupName("Api-Version-0");

        return docket;
    }

    private ApiInfo getApiMetainfo() {
        ApiInfo apiInfo=new ApiInfoBuilder()
                .license("Apache checkpoint license")
                .licenseUrl("www.apache.checkpoint.com")
                .title("Checkpoint Products Documentation")
                .version("2").build();
       return apiInfo;
    }

    @Bean
    public Docket getDocketForNewVersion(){
        Docket docket= new Docket(DocumentationType.SWAGGER_2).select()/*.apis(RequestHandlerSelectors.any()*/
                .apis(RequestHandlerSelectors.basePackage("com.checkpoint")).paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
        docket.apiInfo(getApiMetainfo());
        docket.groupName("Api-Version-1");
        return docket;
    }


    @Bean
    public Docket getDocketForProduction(){
        Docket docket= new Docket(DocumentationType.SWAGGER_2).select()/*.apis(RequestHandlerSelectors.any())*/
                .apis(RequestHandlerSelectors.basePackage("com.checkpoint")).paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
        docket.apiInfo(getApiMetainfo());
        docket.groupName("Production-ENV");
        docket.host("13.233.109.66:9090");
        return docket;
    }



    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/



}
