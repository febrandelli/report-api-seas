package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    Optional<Estado> findById(Integer estadoId);
}
