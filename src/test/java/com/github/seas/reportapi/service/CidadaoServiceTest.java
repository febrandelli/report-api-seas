package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.dto.CidadaoDto;
import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.domain.Estado;
import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.Sexo;
import com.github.seas.reportapi.repository.CidadaoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class CidadaoServiceTest {

    @InjectMocks
    private CidadaoService cidadaoService;

    @Mock
    private CidadaoRepository mockCidadaoRepository;

    private List<Cidadao> mockListaDeCidadoes = new ArrayList<>();

    private CidadaoDto mockCidadaoRequest = new CidadaoDto();

    @Before
    public void setup() {
        Set<Beneficio> mockBeneficios = new HashSet<>();
        mockBeneficios.add(Beneficio.builder().id(1).nomeclatura("APOSENTADORIA").build());
        mockBeneficios.add(Beneficio.builder().id(2).nomeclatura("SEGURO DESEMPREGO").build());

        Set<CasoEspecial> mockCasosEspeciais = new HashSet<>();
        mockCasosEspeciais.add(CasoEspecial.builder().id(1).nomeclatura("CASO ESPECIAL 1").build());
        mockCasosEspeciais.add(CasoEspecial.builder().id(2).nomeclatura("CASO ESPECIAL 2").build());

        Set<Motivo> mockMotivos = new HashSet<>();
        mockMotivos.add(Motivo.builder().id(1).descricao("ABANDONO FAMILIAR").build());

        mockListaDeCidadoes.add(
            Cidadao.builder()
                .id(1L)
                .nome("JOAO DO TESTE 1")
                .cor(Cor.builder().id(1).nomeclatura("PRETO").build())
                .sexo(Sexo.builder().id(1).nomeclatura("MASCULINO").build())
                .cidadeNascimento(Cidade.builder().id(1).nome("JUNDIAI").estado(Estado.builder().id(1).nome("SAO PAULO").uF("SP").build()).build())
                .dataNascimento(LocalDate.of(1992, 12, 21))
                .fonteDeRenda(FonteDeRenda.builder().id(1).nomeclatura("TRABALHO INFORMAL").build())
                .beneficios(mockBeneficios)
                .casosEspeciais(mockCasosEspeciais)
                .motivos(mockMotivos)
                .querSairDasRuas(Boolean.TRUE)
                .build()
        );

        mockListaDeCidadoes.add(
            Cidadao.builder()
                .id(2L)
                .nome("JOAO DO TESTE 2")
                .cor(Cor.builder().id(2).nomeclatura("BRANCO").build())
                .sexo(Sexo.builder().id(1).nomeclatura("MASCULINO").build())
                .cidadeNascimento(Cidade.builder().id(1).nome("JUNDIAI").estado(Estado.builder().id(1).nome("SAO PAULO").uF("SP").build()).build())
                .dataNascimento(LocalDate.of(1985, 12, 21))
                .fonteDeRenda(FonteDeRenda.builder().id(2).nomeclatura("TRABALHO FORMAL").build())
                .beneficios(mockBeneficios)
                .casosEspeciais(mockCasosEspeciais)
                .motivos(mockMotivos)
                .querSairDasRuas(Boolean.TRUE)
                .build()
        );

        mockListaDeCidadoes.add(
            Cidadao.builder()
                .id(3L)
                .nome("MARIA DO TESTE 1")
                .cor(Cor.builder().id(2).nomeclatura("BRANCO").build())
                .sexo(Sexo.builder().id(2).nomeclatura("FEMININO").build())
                .cidadeNascimento(Cidade.builder().id(1).nome("JUNDIAI").estado(Estado.builder().id(1).nome("SAO PAULO").uF("SP").build()).build())
                .dataNascimento(LocalDate.of(1985, 12, 21))
                .fonteDeRenda(FonteDeRenda.builder().id(2).nomeclatura("TRABALHO FORMAL").build())
                .beneficios(mockBeneficios)
                .casosEspeciais(mockCasosEspeciais)
                .motivos(mockMotivos)
                .querSairDasRuas(Boolean.TRUE)
                .build()
        );
    }

    @Test
    public void buscarTodosOsCidadoesComSucesso() {

        Mockito.when(mockCidadaoRepository.findAll(Mockito.any(Example.class))).thenReturn(mockListaDeCidadoes);

        ResponseEntity<List<Cidadao>> response = cidadaoService.listAllCidadoes(mockCidadaoRequest);

        Assert.assertEquals(mockListaDeCidadoes, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void buscarUmCidadaoEspecifico() {
        List<Cidadao> mockCidadaoEspecifico = new ArrayList<>();
        mockCidadaoEspecifico.add(mockListaDeCidadoes.get(0));

        Mockito.when(mockCidadaoRepository.findAll(Mockito.any(Example.class))).thenReturn(mockCidadaoEspecifico);

        ResponseEntity<List<Cidadao>> response = cidadaoService.listAllCidadoes(mockCidadaoRequest);

        Assert.assertEquals(mockCidadaoEspecifico, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void buscarUmCidadaoQueNaoExiste() {
        Mockito.when(mockCidadaoRepository.findAll(Mockito.any(Example.class))).thenReturn(new ArrayList());

        ResponseEntity<List<Cidadao>> response = cidadaoService.listAllCidadoes(mockCidadaoRequest);

        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
