package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUserName(String usuario);
}
