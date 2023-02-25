package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Servico;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

@Component
public class ServicoConverter
				extends Converter<Servico, GenericDto> {
		@Override
		public Servico fromDto(GenericDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				return Servico.builder()
								.id(dto.getId())
								.nomeclatura(dto.getNomeclatura())
								.build();
		}

		@Override
		public GenericDto toDto(Servico servico) {
				return GenericDto.builder()
								.id(servico.getId())
								.nomeclatura(servico.getNomeclatura())
								.build();
		}
}
