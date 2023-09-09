package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class CasoEspecialConverter
				extends Converter<CasoEspecial, GenericDto> {
		@Override
		public CasoEspecial fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return CasoEspecial.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(CasoEspecial casoEspecial) {
				return GenericDto.builder()
								.id(casoEspecial.getId())
								.nomeclatura(casoEspecial.getNomeclatura())
								.build();
		}
}
