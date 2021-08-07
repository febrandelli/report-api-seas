package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Questionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
}
