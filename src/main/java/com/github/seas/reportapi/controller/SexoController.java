package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Sexo;
import com.github.seas.reportapi.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sexo")
public class SexoController implements SexoDefinition{

    @Autowired
    SexoService sexoService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Sexo>> getAllSexo() {
        return sexoService.getAllSexo();
    }
}
