package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cor")
public class CorController implements CorDefinition {

    @Autowired
    CorService corService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Cor>> getAllCor() {
        return corService.getAllCor();
    }
}
