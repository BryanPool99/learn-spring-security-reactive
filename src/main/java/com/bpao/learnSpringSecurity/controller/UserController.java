package com.bpao.learnSpringSecurity.controller;

import com.bpao.learnSpringSecurity.model.entity.UserEntity;
import com.bpao.learnSpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/saludo")
    public Mono<String> saludoTodoPublico() {
        return Mono.just("Saludo para todos publico sin necesidad de logearte");
    }

    @GetMapping("/test-db")
    public Mono<UserEntity> obtenerUsuario(){
        return userRepository.findByUsername("admin");
    }
}
