package com.bpao.learnSpringSecurity.controller;

import com.bpao.learnSpringSecurity.model.dto.request.AuthRequestDto;
import com.bpao.learnSpringSecurity.model.dto.response.TokenResponseDto;
import com.bpao.learnSpringSecurity.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ReactiveAuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public Mono<ResponseEntity<TokenResponseDto>> login(@RequestBody AuthRequestDto request) {
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()))
                .map(auth ->
                        ResponseEntity.ok(new TokenResponseDto(jwtProvider.generateToken((UserDetails) auth.getPrincipal()))))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
}
