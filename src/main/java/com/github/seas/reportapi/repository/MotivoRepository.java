package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MotivoRepository extends JpaRepository<Motivo, Integer> {
	Set<Motivo> findByIdIn(Set<Integer> ids);
}
