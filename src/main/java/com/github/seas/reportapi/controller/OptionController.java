package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.domain.Estado;
import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.Sexo;
import com.github.seas.reportapi.domain.dto.DocumentTypeDto;
import com.github.seas.reportapi.domain.dto.SearchOptionalDto;
import com.github.seas.reportapi.domain.enums.DocumentTypeEnum;
import com.github.seas.reportapi.domain.enums.ModalityEnum;
import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import com.github.seas.reportapi.domain.enums.PeriodoSituacaoRuaEnum;
import com.github.seas.reportapi.domain.enums.SatisfactionEnum;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.BeneficioService;
import com.github.seas.reportapi.service.CasoEspecialService;
import com.github.seas.reportapi.service.CidadaoService;
import com.github.seas.reportapi.service.CidadeService;
import com.github.seas.reportapi.service.CorService;
import com.github.seas.reportapi.service.EstadoService;
import com.github.seas.reportapi.service.FonteDeRendaService;
import com.github.seas.reportapi.service.MotivoService;
import com.github.seas.reportapi.service.ServicoService;
import com.github.seas.reportapi.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping()
public class OptionController	implements OptionControllerDefinition {
		private final SexoService sexoService;
		private final MotivoService motivoService;
		private final FonteDeRendaService fonteDeRendaService;
		private final CorService corService;
		private final EstadoService estadoService;
		private final CidadeService cidadeService;
		private final CasoEspecialService casoEspecialService;
		private final BeneficioService beneficioService;
		private final ServicoService servicoService;
		private final CidadaoService cidadaoService;

		@Autowired
		public OptionController(SexoService sexoService, MotivoService motivoService, FonteDeRendaService fonteDeRendaService, CorService corService, EstadoService estadoService,
						CidadeService cidadeService, CasoEspecialService casoEspecialService, BeneficioService beneficioService, ServicoService servicoService, CidadaoService cidadaoService) {
				this.sexoService = sexoService;
				this.motivoService = motivoService;
				this.fonteDeRendaService = fonteDeRendaService;
				this.corService = corService;
				this.estadoService = estadoService;
				this.cidadeService = cidadeService;
				this.casoEspecialService = casoEspecialService;
				this.beneficioService = beneficioService;
				this.servicoService = servicoService;
				this.cidadaoService = cidadaoService;
		}

		@GetMapping("/sexo")
		public ResponseEntity<List<Sexo>> getAllSexo() {
				return sexoService.getAllSexo();
		}

		@GetMapping("/motivo")
		public ResponseEntity<List<Motivo>> getAllMotivo() {
				return motivoService.getAllMotivo();
		}

		@GetMapping("/fontederenda")
		public ResponseEntity<List<FonteDeRenda>> getAllFonteDeRenda() {
				return fonteDeRendaService.getAllFonteDeRenda();
		}

		@GetMapping("/documentType")
		public ResponseEntity<List<DocumentTypeDto>> getAllDocumentType() {
				return ResponseEntity.ok(DocumentTypeEnum.getAllDocumentType().stream()
								.map(DocumentTypeDto::new).collect(Collectors.toList()));
		}

		@GetMapping("/cor")
		public ResponseEntity<List<Cor>> getAllCor() {
				return corService.getAllCor();
		}

		@GetMapping("/estado")
		public ResponseEntity<List<Estado>> getAllEstado() {
				return estadoService.getAllEstado();
		}

		@GetMapping("/cidade/{idEstado}")
		public ResponseEntity<List<Cidade>> getAllCidades(@PathVariable("idEstado") Integer estadoId) throws NotFoundException {
				return cidadeService.getCidadesByEstado(estadoId);
		}

		@GetMapping("/casoespecial")
		public ResponseEntity<List<CasoEspecial>> getAllCasoEspecial() {
				return casoEspecialService.getAllCasoEspecial();
		}

		@GetMapping("/beneficio")
		public ResponseEntity<List<Beneficio>> getAllBeneficios() {
				return beneficioService.getAllBeneficio();
		}

		@GetMapping("/search/reasonApproaches")
		public List<SearchOptionalDto> searchReasons () {
				List<SearchOptionalDto> searchReasons = new ArrayList<>();
				Arrays.stream(MotivoAbordagemEnum.values()).forEach(reason -> searchReasons.add(new SearchOptionalDto(reason.name(), reason.name())));
				return searchReasons;
		}

		@GetMapping("/search/timeInJundiai")
		public List<SearchOptionalDto> searchTimeInJundiai () {
				List<SearchOptionalDto> searchTimeInJundiai = new ArrayList<>();
				Arrays.stream(PeriodoJundiaiEnum.values()).forEach(timeInJundiai -> searchTimeInJundiai.add(new SearchOptionalDto(timeInJundiai.name(), timeInJundiai.name())));
				return searchTimeInJundiai;
		}

		@GetMapping("/search/timeLivingOnTheStreet")
		public List<SearchOptionalDto> searchTimeLivingOnTheStreet () {
				List<SearchOptionalDto> searchTimeLivingOnTheStreet = new ArrayList<>();
				Arrays.stream(PeriodoSituacaoRuaEnum.values()).forEach(reason -> searchTimeLivingOnTheStreet.add(new SearchOptionalDto(reason.name(), reason.name())));
				return searchTimeLivingOnTheStreet;
		}

		@GetMapping("/search/modality")
		public List<SearchOptionalDto> searchModality () {
				List<SearchOptionalDto> modalities = new ArrayList<>();
				Arrays.stream(ModalityEnum.values()).forEach(modality -> modalities.add(new SearchOptionalDto(modality.name(), modality.getNomenclatura())));
				return modalities;
		}

		@GetMapping("/search/satisfaction")
		public List<SearchOptionalDto> searchSatisfaction () {
				List<SearchOptionalDto> satisfactions = new ArrayList<>();
				Arrays.stream(SatisfactionEnum.values()).forEach(satisfaction -> satisfactions.add(new SearchOptionalDto(satisfaction.name(), satisfaction.name())));
				return satisfactions;
		}

		@GetMapping("search/services")
		public List<SearchOptionalDto> searchServices() {
				return servicoService.getServicos();
		}

		@GetMapping("/search/cidadaos")
		public List<SearchOptionalDto> searchCidadaos() {
				return cidadaoService.getCidadaos();
		}



}
