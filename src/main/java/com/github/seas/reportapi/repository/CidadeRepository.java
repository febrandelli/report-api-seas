package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<List<Cidade>> findByEstado(Estado estado);

    Optional<Cidade> findByNome(String nome);
}
