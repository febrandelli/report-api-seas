package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {
}
