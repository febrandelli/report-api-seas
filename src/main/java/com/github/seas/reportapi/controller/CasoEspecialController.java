package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.service.CasoEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/casoespecial")
public class CasoEspecialController implements CasoEspecialDefinition {

    @Autowired
    CasoEspecialService casoEspecialService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<CasoEspecial>> getAllCasoEspecial() {
        return casoEspecialService.getAllCasoEspecial();
    }
}
