package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.repository.FonteDeRendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonteDeRendaService {

    @Autowired
    FonteDeRendaRepository fonteDeRendaRepository;

    public ResponseEntity<List<FonteDeRenda>> getAllFonteDeRenda() {
        List<FonteDeRenda> fontesDeRenda = fonteDeRendaRepository.findAll();
        return ResponseEntity.ok(fontesDeRenda);
    }
}
