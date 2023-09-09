package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class CorConverter
				extends Converter<Cor, GenericDto> {
		@Override
		public Cor fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return Cor.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(Cor cor) {
				return GenericDto.builder()
								.id(cor.getId())
								.nomeclatura(cor.getNomeclatura())
								.build();
		}
}
