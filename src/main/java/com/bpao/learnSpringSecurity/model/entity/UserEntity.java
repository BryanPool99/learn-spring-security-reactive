package com.bpao.learnSpringSecurity.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "usuarios", schema = "springsecurityreactive")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String roles;
    private Boolean enabled;
}
