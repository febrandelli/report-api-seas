package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Sexo;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class SexoConverter extends Converter<Sexo, GenericDto> {
		@Override
		public Sexo fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
					return null;
				}
				return Sexo.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(Sexo sexo) {
				if(this.valideIfIsNull(sexo)) {
						return null;
				}
				return GenericDto.builder()
								.id(sexo.getId())
								.nomeclatura(sexo.getNomeclatura())
								.build();
		}
}
