package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class BeneficioConverter extends Converter<Beneficio, GenericDto> {
		@Override
		public Beneficio fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return Beneficio.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(Beneficio beneficio) {
				return GenericDto.builder()
								.id(beneficio.getId())
								.nomeclatura(beneficio.getNomeclatura())
								.build();
		}
}
