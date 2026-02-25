package com.bpao.learnSpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/hola")
    public Mono<String> saludar(){
        return Mono.just("hola desde controlador publico");
    }
}
