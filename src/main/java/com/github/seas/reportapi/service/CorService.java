package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.repository.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorService {

    @Autowired
    CorRepository corRepository;

    public ResponseEntity<List<Cor>> getAllCor() {
        List<Cor> cores = corRepository.findAll();
        return ResponseEntity.ok(cores);
    }
}
