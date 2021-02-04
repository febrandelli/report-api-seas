package com.github.seas.reportapi.repository;

import com.github.seas.reportapi.domain.Questionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

@Document("questionarios")
public interface QuestionarioRepository extends MongoRepository<Questionario, String> {

    List<Questionario> findByDataBetween(LocalDate firstDay, LocalDate lastDay);

}
