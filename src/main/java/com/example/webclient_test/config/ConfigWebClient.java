package com.example.webclient_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigWebClient {

    String url = "https://jsonplaceholder.typicode.com";

    @Bean
    WebClient client(){
        return WebClient.builder().baseUrl(url).build();
    }
}
