package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.dto.CidadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeConverter extends Converter<Cidade, CidadeDto> {

		private final EstadoConverter estadoConverter;

		@Autowired
		public CidadeConverter(EstadoConverter estadoConverter) {
				this.estadoConverter = estadoConverter;
		}

		@Override
		public Cidade fromDto(CidadeDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return Cidade.builder()
								.id(dto.getId())
								.nome(dto.getNome())
								.estado(estadoConverter.fromDto(dto.getEstado()))
								.build();
		}

		@Override
		public CidadeDto toDto(Cidade cidade) {
				return CidadeDto.builder()
								.id(cidade.getId())
								.nome(cidade.getNome())
								.estado(estadoConverter.toDto(cidade.getEstado()))
								.build();
		}
}
