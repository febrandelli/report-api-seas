package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.domain.dto.SearchOptionalDto;
import com.github.seas.reportapi.controller.form.SearchCidadao;
import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.domain.Cidade;
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
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(new Locale("pt", "BR"));

    public Page<Cidadao> listAllCidadoes(SearchCidadao searchCidadao, Pageable pageable) {
        Cidadao cidadaoToMatch = new Cidadao();
        Set<Beneficio> beneficios = null;
        Set<CasoEspecial> casosEspeciais = null;
        Cidade cidade = null;
        Cor cor = null;
        FonteDeRenda fonteDeRenda = null;
        Set<Motivo> motivos = null;
        Sexo sexo = null;

        if (searchCidadao.getBeneficios() != null) {
            beneficios = beneficioRepository.findByIdIn(searchCidadao.getBeneficios());
            cidadaoToMatch.setBeneficios(beneficios);
        }
        if (searchCidadao.getCasosEspeciais() != null) {
            casosEspeciais = casoEspecialRepository.findByIdIn(searchCidadao.getCasosEspeciais());
            cidadaoToMatch.setCasosEspeciais(casosEspeciais);
        }
        if (searchCidadao.getCidadeNascimento() != null) {
            cidade = cidadeRepository.findById(searchCidadao.getCidadeNascimento()).orElseThrow(() -> new IllegalArgumentException("Id da cidade incorreto"));
            cidadaoToMatch.setCidadeNascimento(cidade);
        }
        if (searchCidadao.getCor() != null) {
            cor = corRepository.findById(searchCidadao.getCor()).orElseThrow(() -> new IllegalArgumentException("Id da cor incorreto"));
            cidadaoToMatch.setCor(cor);
        }
        if (searchCidadao.getFonteDeRenda() != null) {
            fonteDeRenda = fonteDeRendaRepository.findById(searchCidadao.getFonteDeRenda()).orElseThrow(() -> new IllegalArgumentException("Id da fonte de renda incorreto"));
            cidadaoToMatch.setFonteDeRenda(fonteDeRenda);
        }
        if (searchCidadao.getMotivos() != null) {
            motivos = motivoRepository.findByIdIn(searchCidadao.getMotivos());
            cidadaoToMatch.setMotivos(motivos);
        }
        if (searchCidadao.getSexo() != null) {
            sexo = sexoRepository.findById(searchCidadao.getSexo()).orElseThrow(() -> new IllegalArgumentException("Id do sexo incorreto"));
            cidadaoToMatch.setSexo(sexo);
        }

        cidadaoToMatch.setDataNascimento(Objects.isNull(searchCidadao.getDataNascimento()) ? null : LocalDate.parse(searchCidadao.getDataNascimento(), formatter));
        cidadaoToMatch.setNome(searchCidadao.getNome());
        cidadaoToMatch.setQuerSairDasRuas(searchCidadao.getQuerSairDasRuas());
        cidadaoToMatch.setPrecisaParaSairRua(searchCidadao.getPrecisaParaSairRua());

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Cidadao> cidadaoExample = Example.of(cidadaoToMatch, exampleMatcher);

        return cidadaoRepository.findAll(cidadaoExample, pageable);
    }

    public Cidadao createCidadao(Cidadao newCidadao) throws NotFoundException {



        return cidadaoRepository.save(newCidadao);
    }

    public Cidadao updateCidadao(Long idCidadaoToUpdate, Cidadao cidadaoToUpdate) throws NotFoundException {

        Cidadao cidadaoFinded = cidadaoRepository.findById(idCidadaoToUpdate).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        cidadaoFinded.setBeneficios(cidadaoToUpdate.getBeneficios());
        cidadaoFinded.setCasosEspeciais(cidadaoToUpdate.getCasosEspeciais());
        cidadaoFinded.setCidadeNascimento(cidadaoToUpdate.getCidadeNascimento());
        cidadaoFinded.setCor(cidadaoToUpdate.getCor());
        cidadaoFinded.setDataNascimento(cidadaoToUpdate.getDataNascimento());
        cidadaoFinded.setFonteDeRenda(cidadaoToUpdate.getFonteDeRenda());
        cidadaoFinded.setMotivos(cidadaoToUpdate.getMotivos());
        cidadaoFinded.setNome(cidadaoToUpdate.getNome());
        cidadaoFinded.setQuerSairDasRuas(cidadaoToUpdate.getQuerSairDasRuas());
        cidadaoFinded.setSexo(cidadaoToUpdate.getSexo());
        cidadaoFinded.setPrecisaParaSairRua(cidadaoToUpdate.getPrecisaParaSairRua());

        return cidadaoRepository.save(cidadaoFinded);
    }

    public List<SearchOptionalDto> getCidadaos() {
        List<Cidadao> cidadaos = cidadaoRepository.findAll();
        List<SearchOptionalDto> optionalCidadaos = new ArrayList<>();
        cidadaos.forEach(cidadao -> optionalCidadaos.add(new SearchOptionalDto(cidadao.getId().toString(), cidadao.getNome())));
        return optionalCidadaos;
    }
}
