package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.dto.CidadaoDto;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.CidadaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController implements CidadaoDefinition{

    @Autowired
    private CidadaoService cidadaoService;

    @GetMapping()
    public ResponseEntity<List<Cidadao>> getAllCidadoes(@ModelAttribute final CidadaoDto cidadaoRequest){
        return cidadaoService.listAllCidadoes(cidadaoRequest);
    }

    @PostMapping()
    public ResponseEntity<Integer> createCidadao(@RequestBody @Valid CidadaoDto cidadaoToCreate) {
        return cidadaoService.createCidadao(cidadaoToCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateCidadao(
            @RequestBody @Valid CidadaoDto cidadaoToUpdate, @PathVariable(name = "id") Long idCidadaoToUpdate) throws NotFoundException {
        return cidadaoService.updateCidadao(idCidadaoToUpdate, cidadaoToUpdate);
    }
}
