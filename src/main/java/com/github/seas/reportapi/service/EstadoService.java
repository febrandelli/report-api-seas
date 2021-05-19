package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Estado;
import com.github.seas.reportapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public ResponseEntity<List<Estado>> getAllEstado() {
        List<Estado> estados = estadoRepository.findAll();
        return ResponseEntity.ok(estados);
    }
}
