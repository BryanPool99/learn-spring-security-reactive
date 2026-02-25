package com.bpao.learnSpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping("/hola")
    public Mono<String>saludoPrivado(){
        return Mono.just("Saludo desde controlador privado");
    }
}
