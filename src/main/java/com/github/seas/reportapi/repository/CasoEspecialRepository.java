package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.CasoEspecial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CasoEspecialRepository extends JpaRepository<CasoEspecial, Integer> {

	Set<CasoEspecial> findByIdIn(Set<Integer> ids);
}
