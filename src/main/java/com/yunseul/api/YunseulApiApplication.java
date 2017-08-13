package com.yunseul.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunseul.api.util.api.seoul.SeoulApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class YunseulApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(YunseulApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(YunseulApiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public SeoulApiClient seoulApiClient() {
        return new SeoulApiClient();
    }
}
