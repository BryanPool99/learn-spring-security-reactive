package com.bpao.learnSpringSecurity.repository;

import com.bpao.learnSpringSecurity.model.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
    Mono<UserEntity> findByUsername(String username);
}
