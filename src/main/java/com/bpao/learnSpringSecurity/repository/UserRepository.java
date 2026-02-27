package com.bpao.learnSpringSecurity.repository;

import com.bpao.learnSpringSecurity.model.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserEntity,Integer> {
}
