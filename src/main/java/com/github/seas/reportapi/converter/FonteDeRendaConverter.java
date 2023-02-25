package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class FonteDeRendaConverter
				extends Converter<FonteDeRenda, GenericDto> {
		@Override
		public FonteDeRenda fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return FonteDeRenda.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(FonteDeRenda fonteDeRenda) {
				return GenericDto.builder()
								.id(fonteDeRenda.getId())
								.nomeclatura(fonteDeRenda.getNomeclatura())
								.build();
		}
}
