package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Estado;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.CidadeRepository;
import com.github.seas.reportapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    public ResponseEntity<List<Cidade>> getCidadesByEstado(Integer estadoId) throws NotFoundException {
        try {
            Estado estadoToFind = estadoRepository.findById(estadoId).orElseThrow(
                    () -> new NotFoundException("Estado não encontrado."));
            List<Cidade> cidadesFounded = cidadeRepository.findByEstado(estadoToFind).orElse(new ArrayList<>());
            return ResponseEntity.ok(cidadesFounded);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
