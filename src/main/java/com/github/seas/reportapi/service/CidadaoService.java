package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.dto.CidadaoDto;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.CidadaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CidadaoService {

    private final CidadaoRepository cidadaoRepository;

    public ResponseEntity<Page<Cidadao>> listAllCidadoes(CidadaoDto cidadaoDto, Pageable pageable) {
        Cidadao cidadaoToMatch = new Cidadao(cidadaoDto);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Cidadao> cidadaoExample = Example.of(cidadaoToMatch, exampleMatcher);

        Page<Cidadao> cidadoes = cidadaoRepository.findAll(cidadaoExample, pageable);
        if (cidadoes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cidadoes);
    }

    public ResponseEntity<Integer> createCidadao(CidadaoDto cidadaoDto) {
        Cidadao novoCidadao = new Cidadao(cidadaoDto);
        Integer idCidadaoCreated = cidadaoRepository.save(novoCidadao).getId().intValue();
        return ResponseEntity.ok(idCidadaoCreated);
    }

    public ResponseEntity<Integer> updateCidadao(Long idCidadaoToUpdate, CidadaoDto cidadaoDto) throws NotFoundException {
        Cidadao cidadaoFinded = cidadaoRepository.findById(idCidadaoToUpdate).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        cidadaoFinded.setBeneficios(cidadaoDto.getBeneficios());
        cidadaoFinded.setCasosEspeciais(cidadaoDto.getCasosEspeciais());
        cidadaoFinded.setCidadeNascimento(cidadaoDto.getCidadeNascimento());
        cidadaoFinded.setCor(cidadaoDto.getCor());
        cidadaoFinded.setDataNascimento(cidadaoDto.getDataNascimento());
        cidadaoFinded.setFonteDeRenda(cidadaoDto.getFonteDeRenda());
        cidadaoFinded.setMotivos(cidadaoDto.getMotivos());
        cidadaoFinded.setNome(cidadaoDto.getNome());
        cidadaoFinded.setQuerSairDasRuas(cidadaoDto.getQuerSairDasRuas());
        cidadaoFinded.setSexo(cidadaoDto.getSexo());

        Integer idCidadaoUpdated = cidadaoRepository.save(cidadaoFinded).getId().intValue();
        return ResponseEntity.ok(idCidadaoUpdated);
    }
}
