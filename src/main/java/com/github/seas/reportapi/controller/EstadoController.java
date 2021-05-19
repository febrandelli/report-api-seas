package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Estado;
import com.github.seas.reportapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController implements EstadoDefinition {

    @Autowired
    EstadoService estadoService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Estado>> getAllEstado() {
        return estadoService.getAllEstado();
    }
}
