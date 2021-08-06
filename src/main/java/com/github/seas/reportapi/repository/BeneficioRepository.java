package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BeneficioRepository extends JpaRepository<Beneficio, Integer> {

	Set<Beneficio> findByIdIn(Set<Integer> ids);
}
