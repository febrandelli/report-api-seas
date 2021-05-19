package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.service.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beneficio")
public class BeneficioController implements BeneficioDefinition {

    @Autowired
    BeneficioService beneficioService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Beneficio>> getAllBeneficios() {
        return beneficioService.getAllBeneficio();
    }
}
