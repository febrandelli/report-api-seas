package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.dto.SearchOptionalDto;
import com.github.seas.reportapi.domain.Servico;
import com.github.seas.reportapi.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

		private final ServicoRepository servicoRepository;

		@Autowired
		public ServicoService(ServicoRepository servicoRepository) {
				this.servicoRepository = servicoRepository;
		}

		public List<SearchOptionalDto> getServicos() {
				List<Servico> servicos = servicoRepository.findAll();
				List<SearchOptionalDto> optionals = new ArrayList<>();
				servicos.forEach( servico -> optionals.add(new SearchOptionalDto(servico.getId().toString(), servico.getNomeclatura())));
				return optionals;
		}
}
