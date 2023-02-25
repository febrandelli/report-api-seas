package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.dto.CidadaoDto;
import com.github.seas.reportapi.domain.dto.GenericDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CidadaoConverter extends Converter<Cidadao, CidadaoDto> {

		private final BeneficioConverter beneficioConverter;
		private final SexoConverter sexoConverter;
		private final CorConverter corConverter;
		private final CidadeConverter cidadeConverter;
		private final FonteDeRendaConverter fonteDeRendaConverter;
		private final MotivoConverter motivoConverter;
		private final CasoEspecialConverter casoEspecialConverter;

		public CidadaoConverter(BeneficioConverter beneficioConverter, SexoConverter sexoConverter, CorConverter corConverter, CidadeConverter cidadeConverter, FonteDeRendaConverter fonteDeRendaConverter,
						MotivoConverter motivoConverter, CasoEspecialConverter casoEspecialConverter) {
				this.beneficioConverter = beneficioConverter;
				this.sexoConverter = sexoConverter;
				this.corConverter = corConverter;
				this.cidadeConverter = cidadeConverter;
				this.fonteDeRendaConverter = fonteDeRendaConverter;
				this.motivoConverter = motivoConverter;
				this.casoEspecialConverter = casoEspecialConverter;
		}

		@Override
		public Cidadao fromDto(CidadaoDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				Set<Motivo> motivos = dto.getMotivos().stream().map(motivoConverter::fromDto).collect(Collectors.toSet());
				Set<CasoEspecial> casosEspeciais = dto.getCasosEspeciais().stream().map(casoEspecialConverter::fromDto).collect(Collectors.toSet());
				Set<Beneficio> beneficios = dto.getBeneficios().stream().map(beneficioConverter::fromDto).collect(Collectors.toSet());

				return Cidadao.builder()
								.id(dto.getId())
								.nome(dto.getNome())
								.nomePai(dto.getNomePai())
								.nomeMae(dto.getNomeMae())
								.tipoDocumento(dto.getTipoDocumento())
								.numeroDocumento(dto.getNumeroDocumento())
								.dataNascimento(dto.getDataNascimento())
								.sexo(sexoConverter.fromDto(dto.getSexo()))
								.cor(corConverter.fromDto(dto.getCor()))
								.cidadeNascimento(cidadeConverter.fromDto(dto.getCidadeNascimento()))
								.fonteDeRenda(fonteDeRendaConverter.fromDto(dto.getFonteDeRenda()))
								.querSairDasRuas(dto.getQuerSairDasRuas())
								.precisaParaSairRua(dto.getPrecisaParaSairRua())
								.motivos(motivos)
								.casosEspeciais(casosEspeciais)
								.beneficios(beneficios)
								.build();
		}

		@Override
		public CidadaoDto toDto(Cidadao cidadao) {
				List<GenericDto> motivos = cidadao.getMotivos().stream().map(motivoConverter::toDto).collect(Collectors.toList());
				List<GenericDto> casosEspeciais = cidadao.getCasosEspeciais().stream().map(casoEspecialConverter::toDto).collect(Collectors.toList());
				List<GenericDto> beneficios = cidadao.getBeneficios().stream().map(beneficioConverter::toDto).collect(Collectors.toList());

				return CidadaoDto.builder()
								.id(cidadao.getId())
								.nome(cidadao.getNome())
								.nomePai(cidadao.getNomePai())
								.nomeMae(cidadao.getNomeMae())
								.tipoDocumento(cidadao.getTipoDocumento())
								.numeroDocumento(cidadao.getNumeroDocumento())
								.dataNascimento(cidadao.getDataNascimento())
								.sexo(sexoConverter.toDto(cidadao.getSexo()))
								.cor(corConverter.toDto(cidadao.getCor()))
								.cidadeNascimento(cidadeConverter.toDto(cidadao.getCidadeNascimento()))
								.fonteDeRenda(fonteDeRendaConverter.toDto(cidadao.getFonteDeRenda()))
								.querSairDasRuas(cidadao.getQuerSairDasRuas())
								.precisaParaSairRua(cidadao.getPrecisaParaSairRua())
								.motivos(motivos)
								.casosEspeciais(casosEspeciais)
								.beneficios(beneficios)
								.build();
		}
}
