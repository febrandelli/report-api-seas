package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficioService {

    @Autowired
    BeneficioRepository beneficioRepository;

    public ResponseEntity<List<Beneficio>> getAllBeneficio() {
        List<Beneficio> beneficios = beneficioRepository.findAll();
        return ResponseEntity.ok(beneficios);
    }
}
