package com.example.webclient_test.controller;

import com.example.webclient_test.dto.WebClientDto;
import com.example.webclient_test.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class WebClientController {

    @Autowired
    private WebClientService service;

    @PostMapping
    public ResponseEntity<Mono<WebClientDto>> save(@RequestBody WebClientDto dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<WebClientDto>> getPosts(){
        return new ResponseEntity<>(service.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Flux<WebClientDto>> getAllPostByUserId(@PathVariable Integer userId){
        return new ResponseEntity<>(service.getPostByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<WebClientDto>> getPostByPostId(@PathVariable Integer id){
        return new ResponseEntity<>(service.getPostByPostId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<WebClientDto>> update(@PathVariable Integer id, @RequestBody WebClientDto dto){
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>("Post deleted", HttpStatus.OK);
        //return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
