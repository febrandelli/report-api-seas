package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.dto.SearchOptionalDto;
import com.github.seas.reportapi.domain.enums.ModalityEnum;
import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import com.github.seas.reportapi.domain.enums.PeriodoSituacaoRuaEnum;
import com.github.seas.reportapi.domain.enums.SatisfactionEnum;
import com.github.seas.reportapi.service.CidadaoService;
import com.github.seas.reportapi.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchOptionsController {

		private final ServicoService servicoService;
		private final CidadaoService cidadaoService;

		@Autowired
		public SearchOptionsController(ServicoService servicoService, CidadaoService cidadaoService) {
				this.servicoService = servicoService;
				this.cidadaoService = cidadaoService;
		}

		@GetMapping("/reasonApproaches")
		public List<SearchOptionalDto> searchReasons () {
				List<SearchOptionalDto> searchReasons = new ArrayList<>();
				Arrays.stream(MotivoAbordagemEnum.values()).forEach(reason -> searchReasons.add(new SearchOptionalDto(reason.name(), reason.name())));
				return searchReasons;
		}

		@GetMapping("/timeInJundiai")
		public List<SearchOptionalDto> searchTimeInJundiai () {
				List<SearchOptionalDto> searchTimeInJundiai = new ArrayList<>();
				Arrays.stream(PeriodoJundiaiEnum.values()).forEach(timeInJundiai -> searchTimeInJundiai.add(new SearchOptionalDto(timeInJundiai.name(), timeInJundiai.name())));
				return searchTimeInJundiai;
		}

		@GetMapping("/timeLivingOnTheStreet")
		public List<SearchOptionalDto> searchTimeLivingOnTheStreet () {
				List<SearchOptionalDto> searchTimeLivingOnTheStreet = new ArrayList<>();
				Arrays.stream(PeriodoSituacaoRuaEnum.values()).forEach(reason -> searchTimeLivingOnTheStreet.add(new SearchOptionalDto(reason.name(), reason.name())));
				return searchTimeLivingOnTheStreet;
		}

		@GetMapping("/services")
		public List<SearchOptionalDto> searchServices() {
				return servicoService.getServicos();
		}

		@GetMapping("/cidadaos")
		public List<SearchOptionalDto> searchCidadaos() {
				return cidadaoService.getCidadaos();
		}

		@GetMapping("/modality")
		public List<SearchOptionalDto> searchModality () {
				List<SearchOptionalDto> modalities = new ArrayList<>();
				Arrays.stream(ModalityEnum.values()).forEach(modality -> modalities.add(new SearchOptionalDto(modality.name(), modality.getNomenclatura())));
				return modalities;
		}

		@GetMapping("/satisfaction")
		public List<SearchOptionalDto> searchSatisfaction () {
				List<SearchOptionalDto> satisfactions = new ArrayList<>();
				Arrays.stream(SatisfactionEnum.values()).forEach(satisfaction -> satisfactions.add(new SearchOptionalDto(satisfaction.name(), satisfaction.name())));
				return satisfactions;
		}


}
