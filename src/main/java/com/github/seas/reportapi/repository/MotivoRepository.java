package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoRepository extends JpaRepository<Motivo, Integer> {
}
