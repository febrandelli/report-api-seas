package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	Set<Servico> findByIdIn(List<Long> ids);
}
