package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.repository.CasoEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoEspecialService {

    @Autowired
    CasoEspecialRepository casoEspecialRepository;

    public ResponseEntity<List<CasoEspecial>> getAllCasoEspecial() {
        List<CasoEspecial> casosEspeciais = casoEspecialRepository.findAll();
        return ResponseEntity.ok(casosEspeciais);
    }
}
