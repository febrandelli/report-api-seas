package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.service.FonteDeRendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fontederenda")
public class FonteDeRendaController implements FonteDeRendaDefinition {

    @Autowired
    FonteDeRendaService fonteDeRendaService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<FonteDeRenda>> getAllFonteDeRenda() {
        return fonteDeRendaService.getAllFonteDeRenda();
    }
}
