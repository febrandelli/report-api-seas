package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.repository.MotivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivoService {

    @Autowired
    MotivoRepository motivoRepository;

    public ResponseEntity<List<Motivo>> getAllMotivo() {
        List<Motivo> motivos = motivoRepository.findAll();
        return ResponseEntity.ok(motivos);
    }
}
