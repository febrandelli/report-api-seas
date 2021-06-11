package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController implements CidadeDefinition {

    @Autowired
    CidadeService cidadeService;

    @CrossOrigin
    @GetMapping("/{idEstado}")
    public ResponseEntity<List<Cidade>> getAllCidades(@PathVariable("idEstado") Integer estadoId) throws NotFoundException {
        return cidadeService.getCidadesByEstado(estadoId);
    }
}
