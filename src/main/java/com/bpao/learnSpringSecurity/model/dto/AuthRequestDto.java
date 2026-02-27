package com.bpao.learnSpringSecurity.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestDto {
    private String username;
    private String password;
}
