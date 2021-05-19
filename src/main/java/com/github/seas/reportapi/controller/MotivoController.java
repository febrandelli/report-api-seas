package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.service.MotivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/motivo")
public class MotivoController implements MotivoDefinition {

    @Autowired
    MotivoService motivoService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Motivo>> getAllMotivo() {
        return motivoService.getAllMotivo();
    }
}
