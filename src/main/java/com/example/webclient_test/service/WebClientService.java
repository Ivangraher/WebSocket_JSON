package com.example.webclient_test.service;

import com.example.webclient_test.dto.WebClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    @Autowired
    private WebClient client;

    //save a post
    public Mono<WebClientDto> save(WebClientDto dto){
        return client.post().uri("/posts").bodyValue(dto).retrieve().bodyToMono(WebClientDto.class);
    }

    //get N posts
    public Flux<WebClientDto> getPosts(){
        return client.get().uri("/posts").retrieve().bodyToFlux(WebClientDto.class);
    }

    //get post by post Id
    public Mono<WebClientDto> getPostByPostId(Integer id){
        return client.get().uri("/posts/"+id).retrieve().bodyToMono(WebClientDto.class);
    }

    //get all posts by user Id
    public Flux<WebClientDto> getPostByUser(Integer userId){
        return client.get().uri("/users/"+userId+"/posts").retrieve().bodyToFlux(WebClientDto.class);
    }

    //update a post
    public Mono<WebClientDto> update(Integer id, WebClientDto dto){
        return client.put().uri("/posts/"+id).bodyValue(dto).retrieve().bodyToMono(WebClientDto.class);
    }

    //delete a post
    public void delete(Integer id){
        client.delete().uri("/posts/"+id).retrieve().bodyToMono(WebClientDto.class);
    }


}
