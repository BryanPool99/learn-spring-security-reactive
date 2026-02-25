package com.bpao.learnSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity//Habilitamos la seguridad reactiva
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity){
        return httpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)//Desactivamos CSRF (necesario para APIs REST)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/public/**").permitAll()//Ruta libre
                        .anyExchange().authenticated()//lo demás requiere login
                )
                .httpBasic(Customizer.withDefaults()) // 5. Usamos login básico (ventana del navegador)
                .formLogin(Customizer.withDefaults()) // 6. O un formulario visual
                .build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails user = User.builder()
                .username("bpao")
                //.password("{noop}123") el {noop} sirve para indicarle a spring que la contraseña no esta encriptada
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
