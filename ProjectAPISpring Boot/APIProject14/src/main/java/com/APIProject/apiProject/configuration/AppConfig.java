//package com.APIProject.apiProject.configuration;
//
//import com.APIProject.apiProject.exceptions.ErrorHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//@ComponentScan("com.APIProject.apiProject.api")
//public class AppConfig {
//
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate template = new RestTemplate();
//        template.setErrorHandler(errorHandler());
//        return template;
//    }
//
//    @Bean
//    public ErrorHandler errorHandler() {
//        return new ErrorHandler();
//    }
//}
