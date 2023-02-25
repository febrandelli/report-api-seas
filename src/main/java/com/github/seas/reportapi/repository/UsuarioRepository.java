package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String usuario);

    Optional<Usuario> findByEmail(String email);

    Set<Usuario> findByIdIn(List<Long> ids);
    Set<Usuario> findByNomeCompletoIn(List<String> nomes);
}
