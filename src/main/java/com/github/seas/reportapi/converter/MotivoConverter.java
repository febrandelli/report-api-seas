package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class MotivoConverter
				extends Converter<Motivo, GenericDto> {
		@Override
		public Motivo fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return Motivo.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(Motivo motivo) {
				return GenericDto.builder()
								.id(motivo.getId())
								.nomeclatura(motivo.getNomeclatura())
								.build();
		}
}
