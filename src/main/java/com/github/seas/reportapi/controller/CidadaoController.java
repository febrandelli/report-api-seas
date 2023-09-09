package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.dto.CidadaoDto;
import com.github.seas.reportapi.controller.form.SearchCidadao;
import com.github.seas.reportapi.converter.CidadaoConverter;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.CidadaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    private final CidadaoService cidadaoService;
    private final CidadaoConverter cidadaoConverter;

    @Autowired
    public CidadaoController(CidadaoService cidadaoService, CidadaoConverter cidadaoConverter) {
        this.cidadaoService = cidadaoService;
        this.cidadaoConverter = cidadaoConverter;
    }

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<Page<CidadaoDto>> getAllCidadoes(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "10") int size, @ModelAttribute SearchCidadao cidadaoRequest) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cidadao> cidadoes = cidadaoService.listAllCidadoes(cidadaoRequest, pageable);
        Page<CidadaoDto> response = cidadoes.map(cidadaoConverter::toDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping()
    public ResponseEntity<Cidadao> createCidadao(@RequestBody @Valid CidadaoDto cidadaoDto) throws NotFoundException {
        Cidadao newCidadao = cidadaoConverter.fromDto(cidadaoDto);
        return new ResponseEntity(cidadaoService.createCidadao(newCidadao), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Cidadao> updateCidadao(
            @RequestBody @Valid CidadaoDto cidadaoDto, @PathVariable(name = "id") Long idCidadaoToUpdate) throws NotFoundException {
        Cidadao newCidadao = cidadaoConverter.fromDto(cidadaoDto);
        return new ResponseEntity(cidadaoService.updateCidadao(idCidadaoToUpdate, newCidadao), HttpStatus.OK);
    }
}
