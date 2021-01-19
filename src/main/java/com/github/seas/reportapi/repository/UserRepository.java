package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Document("users")
public interface UserRepository extends MongoRepository<User, String> {

    public Optional<User> findByUsuario(String usuario);
}
