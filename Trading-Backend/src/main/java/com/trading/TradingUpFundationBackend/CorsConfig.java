package com.trading.TradingUpFundationBackend;

import org.springframework.context.annotation.Configuration;//Package that allows to define this class like a configuration in the spring container and the sprig context
import org.springframework.web.servlet.config.annotation.CorsRegistry;//Package to configure the access policy in a web application
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;//Interface that allows to customize and config some important aspects of the spring MVC

@Configuration//This annotation marks a class like a source of definitions of spring bean's and the configuration of the components in the application

/**
 *  Class that configs the access policy of cross resources to allow the access of resources of domains different of the server domain of the application
 *  Implements the interface WebMvcConfigurer to config the CORS policy
 */
public class CorsConfig implements WebMvcConfigurer {
    @Override//Annotation that brings a method since a interface implemented
    /**
     * Class that allows the config and customize the CORS of a domain
     */
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}