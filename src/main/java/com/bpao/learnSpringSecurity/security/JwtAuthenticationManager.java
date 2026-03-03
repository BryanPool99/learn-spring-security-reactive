package com.bpao.learnSpringSecurity.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {
    private final JwtProvider jwtProvider;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String token = authentication.getCredentials().toString();

        return Mono.just(token)
                .map(t -> {
                    if (!jwtProvider.validateToken(t)) {
                        throw new BadCredentialsException("Token expirado o inválido");
                    }

                    String username = jwtProvider.getUsernameFromToken(t);

                    // 1. Creamos el token de autenticación
                    // 2. IMPORTANTE: Hacemos el cast a (Authentication) para evitar el error de tipo
                    return (Authentication) new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            List.of() // Aquí irán los roles luego
                    );
                })
                .onErrorResume(e -> Mono.error(new BadCredentialsException(e.getMessage())));
    }
}
