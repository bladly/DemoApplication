package com.example.demo.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DemoThirdPartyAPIService {

    private final WebClient webClient;

    @Autowired
    public DemoThirdPartyAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public String getPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn("Error occurred while fetching posts").block();
    }
}
