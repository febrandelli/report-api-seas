package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.dto.CidadaoDto;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.CidadaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController implements CidadaoDefinition {

    @Autowired
    private CidadaoService cidadaoService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<Page<Cidadao>> getAllCidadoes(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "10") int size, @ModelAttribute final CidadaoDto cidadaoRequest) {
        Pageable pageable = PageRequest.of(page, size);
        return cidadaoService.listAllCidadoes(cidadaoRequest, pageable);
    }

    @CrossOrigin
    @PostMapping()
    public ResponseEntity<Cidadao> createCidadao(@RequestBody @Valid CidadaoDto cidadaoToCreate) {
        return cidadaoService.createCidadao(cidadaoToCreate);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Cidadao> updateCidadao(
            @RequestBody @Valid CidadaoDto cidadaoToUpdate, @PathVariable(name = "id") Long idCidadaoToUpdate) throws NotFoundException {
        return cidadaoService.updateCidadao(idCidadaoToUpdate, cidadaoToUpdate);
    }
}
