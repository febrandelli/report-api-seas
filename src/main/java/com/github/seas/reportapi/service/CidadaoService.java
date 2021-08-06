package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.dto.CidadaoDto;
import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.Sexo;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.BeneficioRepository;
import com.github.seas.reportapi.repository.CasoEspecialRepository;
import com.github.seas.reportapi.repository.CidadaoRepository;
import com.github.seas.reportapi.repository.CidadeRepository;
import com.github.seas.reportapi.repository.CorRepository;
import com.github.seas.reportapi.repository.FonteDeRendaRepository;
import com.github.seas.reportapi.repository.MotivoRepository;
import com.github.seas.reportapi.repository.SexoRepository;
import javassist.tools.web.BadHttpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CidadaoService {

    private final CidadaoRepository cidadaoRepository;
    private final BeneficioRepository beneficioRepository;
    private final CasoEspecialRepository casoEspecialRepository;
    private final CidadeRepository cidadeRepository;
    private final CorRepository corRepository;
    private final FonteDeRendaRepository fonteDeRendaRepository;
    private final MotivoRepository motivoRepository;
    private final SexoRepository sexoRepository;

    public ResponseEntity<Page<Cidadao>> listAllCidadoes(CidadaoDto cidadaoDto, Pageable pageable) {
        Set<Beneficio> beneficios = beneficioRepository.findByIdIn(cidadaoDto.getBeneficios());
        Set<CasoEspecial> casosEspeciais = casoEspecialRepository.findByIdIn(cidadaoDto.getCasosEspeciais());
        Cidade cidade = cidadeRepository.findById(cidadaoDto.getCidadeNascimento()).orElseThrow(() -> new IllegalArgumentException("Id da cidade incorreto"));
        Cor cor = corRepository.findById(cidadaoDto.getCor()).orElseThrow(() -> new IllegalArgumentException("Id da cor incorreto"));
        FonteDeRenda fonteDeRenda = fonteDeRendaRepository.findById(cidadaoDto.getFonteDeRenda()).orElseThrow(() -> new IllegalArgumentException("Id da fonte de renda incorreto"));
        Set<Motivo> motivos = motivoRepository.findByIdIn(cidadaoDto.getMotivos());
        Sexo sexo = sexoRepository.findById(cidadaoDto.getSexo()).orElseThrow(() -> new IllegalArgumentException("Id do sexo incorreto"));

        Cidadao cidadaoToMatch = new Cidadao();
        cidadaoToMatch.setBeneficios(beneficios);
        cidadaoToMatch.setCasosEspeciais(casosEspeciais);
        cidadaoToMatch.setCidadeNascimento(cidade);
        cidadaoToMatch.setCor(cor);
        cidadaoToMatch.setDataNascimento(cidadaoDto.getDataNascimento());
        cidadaoToMatch.setFonteDeRenda(fonteDeRenda);
        cidadaoToMatch.setMotivos(motivos);
        cidadaoToMatch.setNome(cidadaoDto.getNome());
        cidadaoToMatch.setQuerSairDasRuas(cidadaoDto.getQuerSairDasRuas());
        cidadaoToMatch.setSexo(sexo);
        cidadaoToMatch.setPrecisaParaSairRua(cidadaoDto.getPrecisaParaSairRua());

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

    public ResponseEntity<Cidadao> createCidadao(CidadaoDto cidadaoDto) {
        Set<Beneficio> beneficios = beneficioRepository.findByIdIn(cidadaoDto.getBeneficios());
        Set<CasoEspecial> casosEspeciais = casoEspecialRepository.findByIdIn(cidadaoDto.getCasosEspeciais());
        Cidade cidade = cidadeRepository.findById(cidadaoDto.getCidadeNascimento()).orElseThrow(() -> new IllegalArgumentException("Id da cidade incorreto"));
        Cor cor = corRepository.findById(cidadaoDto.getCor()).orElseThrow(() -> new IllegalArgumentException("Id da cor incorreto"));
        FonteDeRenda fonteDeRenda = fonteDeRendaRepository.findById(cidadaoDto.getFonteDeRenda()).orElseThrow(() -> new IllegalArgumentException("Id da fonte de renda incorreto"));
        Set<Motivo> motivos = motivoRepository.findByIdIn(cidadaoDto.getMotivos());
        Sexo sexo = sexoRepository.findById(cidadaoDto.getSexo()).orElseThrow(() -> new IllegalArgumentException("Id do sexo incorreto"));

        Cidadao novoCidadao = new Cidadao();
        novoCidadao.setBeneficios(beneficios);
        novoCidadao.setCasosEspeciais(casosEspeciais);
        novoCidadao.setCidadeNascimento(cidade);
        novoCidadao.setCor(cor);
        novoCidadao.setDataNascimento(cidadaoDto.getDataNascimento());
        novoCidadao.setFonteDeRenda(fonteDeRenda);
        novoCidadao.setMotivos(motivos);
        novoCidadao.setNome(cidadaoDto.getNome());
        novoCidadao.setQuerSairDasRuas(cidadaoDto.getQuerSairDasRuas());
        novoCidadao.setSexo(sexo);
        novoCidadao.setPrecisaParaSairRua(cidadaoDto.getPrecisaParaSairRua());

        Cidadao cidadaoCreated = cidadaoRepository.save(novoCidadao);
        return ResponseEntity.ok(cidadaoCreated);
    }

    public ResponseEntity<Cidadao> updateCidadao(Long idCidadaoToUpdate, CidadaoDto cidadaoDto) throws NotFoundException {
        Set<Beneficio> beneficios = beneficioRepository.findByIdIn(cidadaoDto.getBeneficios());
        Set<CasoEspecial> casosEspeciais = casoEspecialRepository.findByIdIn(cidadaoDto.getCasosEspeciais());
        Cidade cidade = cidadeRepository.findById(cidadaoDto.getCidadeNascimento()).orElseThrow(() -> new IllegalArgumentException("Id da cidade incorreto"));
        Cor cor = corRepository.findById(cidadaoDto.getCor()).orElseThrow(() -> new IllegalArgumentException("Id da cor incorreto"));
        FonteDeRenda fonteDeRenda = fonteDeRendaRepository.findById(cidadaoDto.getFonteDeRenda()).orElseThrow(() -> new IllegalArgumentException("Id da fonte de renda incorreto"));
        Set<Motivo> motivos = motivoRepository.findByIdIn(cidadaoDto.getMotivos());
        Sexo sexo = sexoRepository.findById(cidadaoDto.getSexo()).orElseThrow(() -> new IllegalArgumentException("Id do sexo incorreto"));

        Cidadao cidadaoFinded = cidadaoRepository.findById(idCidadaoToUpdate).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        cidadaoFinded.setBeneficios(beneficios);
        cidadaoFinded.setCasosEspeciais(casosEspeciais);
        cidadaoFinded.setCidadeNascimento(cidade);
        cidadaoFinded.setCor(cor);
        cidadaoFinded.setDataNascimento(cidadaoDto.getDataNascimento());
        cidadaoFinded.setFonteDeRenda(fonteDeRenda);
        cidadaoFinded.setMotivos(motivos);
        cidadaoFinded.setNome(cidadaoDto.getNome());
        cidadaoFinded.setQuerSairDasRuas(cidadaoDto.getQuerSairDasRuas());
        cidadaoFinded.setSexo(sexo);
        cidadaoFinded.setPrecisaParaSairRua(cidadaoDto.getPrecisaParaSairRua());

        Cidadao cidadaoUpdated = cidadaoRepository.save(cidadaoFinded);
        return ResponseEntity.ok(cidadaoUpdated);
    }
}
