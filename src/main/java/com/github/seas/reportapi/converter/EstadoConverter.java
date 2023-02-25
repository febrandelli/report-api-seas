package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Estado;
import com.github.seas.reportapi.domain.dto.EstadoDto;
import org.springframework.stereotype.Component;

@Component
public class EstadoConverter
				extends Converter<Estado, EstadoDto> {
		@Override
		public Estado fromDto(EstadoDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return Estado.builder()
								.id(dto.getId())
								.nome(dto.getNome())
								.uf(dto.getUf())
								.build();
		}

		@Override
		public EstadoDto toDto(Estado estado) {
				return EstadoDto.builder()
								.id(estado.getId())
								.nome(estado.getNome())
								.uf(estado.getUf())
								.build();
		}
}
