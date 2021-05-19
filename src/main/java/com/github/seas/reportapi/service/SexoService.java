package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Sexo;
import com.github.seas.reportapi.repository.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexoService {

    @Autowired
    SexoRepository sexoRepository;

    public ResponseEntity<List<Sexo>> getAllSexo() {
        List<Sexo> sexos = sexoRepository.findAll();
        return ResponseEntity.ok(sexos);
    }
}
