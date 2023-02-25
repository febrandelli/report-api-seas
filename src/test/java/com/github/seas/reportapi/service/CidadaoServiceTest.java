//package com.github.seas.reportapi.service;
//
//import com.github.seas.reportapi.domain.dto.CidadaoDto;
//import com.github.seas.reportapi.domain.Beneficio;
//import com.github.seas.reportapi.domain.CasoEspecial;
//import com.github.seas.reportapi.domain.Cidadao;
//import com.github.seas.reportapi.domain.Cidade;
//import com.github.seas.reportapi.domain.Cor;
//import com.github.seas.reportapi.domain.Estado;
//import com.github.seas.reportapi.domain.FonteDeRenda;
//import com.github.seas.reportapi.domain.Motivo;
//import com.github.seas.reportapi.domain.Sexo;
//import com.github.seas.reportapi.repository.BeneficioRepository;
//import com.github.seas.reportapi.repository.CasoEspecialRepository;
//import com.github.seas.reportapi.repository.CidadaoRepository;
//import com.github.seas.reportapi.repository.CidadeRepository;
//import com.github.seas.reportapi.repository.CorRepository;
//import com.github.seas.reportapi.repository.FonteDeRendaRepository;
//import com.github.seas.reportapi.repository.MotivoRepository;
//import com.github.seas.reportapi.repository.SexoRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.data.domain.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.ArgumentMatchers.anySet;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CidadaoServiceTest {
//
//    @InjectMocks
//    private CidadaoService cidadaoService;
//
//    @Mock
//    private CidadaoRepository mockCidadaoRepository;
//
//    @Mock
//    private BeneficioRepository mockBeneficioRepository;
//
//    @Mock
//    private CasoEspecialRepository mockCasoEspecialRepository;
//
//    @Mock
//    private CidadeRepository mockCidadeRepository;
//
//    @Mock
//    private CorRepository mockCorRepository;
//
//    @Mock
//    private FonteDeRendaRepository mockFonteDeRendaRepository;
//
//    @Mock
//    private MotivoRepository mockMotivoRepository;
//
//    @Mock
//    private SexoRepository mockSexoRepository;
//
//    @Mock
//    private Page<Cidadao> mockPageCidadao;
//    //    private List<Cidadao> mockListaDeCidadoes = new ArrayList<>();
//    //
//
//    @Before
//    public void setup() {
//
//    }
//
//    @Test
//    public void buscarTodosOsCidadoesPorBeneficios() {
//
//        CidadaoDto mockDto = mock(CidadaoDto.class);
//        List<String> mockIdBeneficios = mock(List.class);
//        Set<Beneficio> mockBeneficios = mock(Set.class);
//        Pageable mockPageable = mock(Pageable.class);
//        Page mockPageCidadao = mock(Page.class);
//
//        when(mockCidadaoRepository.findAll(any(Example.class), any(Pageable.class))).thenReturn(mockPageCidadao);
//        when(mockDto.getBeneficios()).thenReturn(mockIdBeneficios);
//        when(mockDto.getCasosEspeciais()).thenReturn(null);
//        when(mockDto.getCidadeNascimento()).thenReturn(null);
//        when(mockDto.getCor()).thenReturn(null);
//        when(mockDto.getFonteDeRenda()).thenReturn(null);
//        when(mockDto.getMotivos()).thenReturn(null);
//        when(mockDto.getSexo()).thenReturn(null);
//
//
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        verify(mockCidadaoRepository, times(1)).findAll(any(Example.class), eq(mockPageable));
//        verify(mockBeneficioRepository, times(1)).findByIdIn(anySet());
//        verify(mockCasoEspecialRepository, never()).findByIdIn(anySet());
//        verify(mockCidadeRepository, never()).findById(anyLong());
//        verify(mockCorRepository, never()).findById(anyInt());
//        verify(mockFonteDeRendaRepository, never()).findById(anyInt());
//        verify(mockMotivoRepository, never()).findById(anyInt());
//        verify(mockSexoRepository, never()).findById(anyInt());
//    }
//
////    @Test
////    public void buscarUmCidadaoEspecifico() {
////        List<Cidadao> mockCidadaoEspecifico = new ArrayList<>();
////        mockCidadaoEspecifico.add(mockListaDeCidadoes.get(0));
////        mockPageCidadao = new PageImpl<>(mockCidadaoEspecifico);
////        Pageable pageable = PageRequest.of(0, 10);
////        when(mockCidadaoRepository.findAll(any(Example.class), any(Pageable.class))).thenReturn(mockPageCidadao);
////
////        CidadaoDto mockDto = mock(CidadaoDto.class);
////
////        ResponseEntity<Page<Cidadao>> response = cidadaoService.listAllCidadoes(mockDto, pageable);
////
////        Assert.assertEquals(mockCidadaoEspecifico, response.getBody().getContent());
////        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
////    }
////
////    @Test
////    public void buscarUmCidadaoQueNaoExiste() {
////        CidadaoDto mockDto = mock(CidadaoDto.class);
////
////        mockPageCidadao = new PageImpl<>(new ArrayList<>());
////        when(mockCidadaoRepository.findAll(any(Example.class), any(Pageable.class))).thenReturn(mockPageCidadao);
////        Pageable pageable = PageRequest.of(0, 10);
////        ResponseEntity<Page<Cidadao>> response = cidadaoService.listAllCidadoes(mockDto, pageable);
////
////        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
////    }
//}
