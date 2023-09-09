package com.github.seas.reportapi.converter;

import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.domain.Servico;
import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.domain.dto.GenericDto;
import com.github.seas.reportapi.domain.dto.QuestionarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class QuestionarioConverter extends Converter<Questionario, QuestionarioDto> {

		private final CidadaoConverter cidadaoConverter;
		private final CidadeConverter cidadeConverter;
		private final ServicoConverter servicoConverter;

		@Autowired
		private QuestionarioConverter(CidadaoConverter cidadaoConverter, CidadeConverter cidadeConverter, ServicoConverter servicoConverter) {
				this.cidadaoConverter = cidadaoConverter;
				this.cidadeConverter = cidadeConverter;
				this.servicoConverter = servicoConverter;
		}

		@Override
		public Questionario fromDto(QuestionarioDto dto) {
				if(this.valideIfIsNull(dto)) {
						return null;
				}
				Set<Servico> servicos = dto.getServicoBuscaJundiai().stream().map(servicoConverter::fromDto).collect(Collectors.toSet());
				Set<Usuario> responsaveis = dto.getResponsaveisPreenchimento().stream().map(usuario -> Usuario.builder().nomeCompleto(usuario).build()).collect(Collectors.toSet());

				return Questionario.builder()
								.id(dto.getId())
								.numeroChamado(dto.getNumeroChamado())
								.cidadao(cidadaoConverter.fromDto(dto.getCidadao()))
								.motivoAbordagem(dto.getMotivoAbordagem())
								.dtInsert(dto.getDtInsert())
								.dtUpdate(dto.getDtUpdate())
								.local(dto.getLocal())
								.circulacaoPelaCidade(dto.getCirculacaoPelaCidade())
								.cidadeOrigem(cidadeConverter.fromDto(dto.getCidadeOrigem()))
								.comoSeVeNaRuaEFora(dto.getComoSeVeNaRuaEFora())
								.projetoDeVida(dto.getProjetoDeVida())
								.tempoJundiai(dto.getTempoJundiai())
								.tempoSituacaoRua(dto.getTempoSituacaoRua())
								.servicoBuscaJundiai(servicos)
								.equipeComposta(dto.getEquipeComposta())
								.qtPessoasAbordadas(dto.getQtPessoasAbordadas())
								.qtPessoasVisualizadas(dto.getQtPessoasVisualizadas())
								.relatoAbordagem(dto.getRelatoAbordagem())
								.servicoAcionado(dto.getServicoAcionado())
								.orientacao(dto.getOrientacao())
								.encaminhamento(dto.getEncaminhamento())
								.satisfaction(dto.getSatisfaction())
								.observacao(dto.getObservacao())
								.responsavelPreenchimento(responsaveis)
								.build();
		}

		@Override
		public QuestionarioDto toDto(Questionario questionario) {
				List<GenericDto> servicos = questionario.getServicoBuscaJundiai().stream().map(servicoConverter::toDto).collect(Collectors.toList());
				List<String> responsaveis = questionario.getResponsavelPreenchimento().stream().map(Usuario::getNomeCompleto).collect(Collectors.toList());

				return QuestionarioDto.builder()
								.id(questionario.getId())
								.numeroChamado(questionario.getNumeroChamado())
								.cidadao(cidadaoConverter.toDto(questionario.getCidadao()))
								.motivoAbordagem(questionario.getMotivoAbordagem())
								.dtInsert(questionario.getDtInsert())
								.dtUpdate(questionario.getDtUpdate())
								.local(questionario.getLocal())
								.circulacaoPelaCidade(questionario.getCirculacaoPelaCidade())
								.cidadeOrigem(cidadeConverter.toDto(questionario.getCidadeOrigem()))
								.comoSeVeNaRuaEFora(questionario.getComoSeVeNaRuaEFora())
								.projetoDeVida(questionario.getProjetoDeVida())
								.tempoJundiai(questionario.getTempoJundiai())
								.tempoSituacaoRua(questionario.getTempoSituacaoRua())
								.servicoBuscaJundiai(servicos)
								.equipeComposta(questionario.getEquipeComposta())
								.qtPessoasAbordadas(questionario.getQtPessoasAbordadas())
								.qtPessoasVisualizadas(questionario.getQtPessoasVisualizadas())
								.relatoAbordagem(questionario.getRelatoAbordagem())
								.servicoAcionado(questionario.getServicoAcionado())
								.orientacao(questionario.getOrientacao())
								.encaminhamento(questionario.getEncaminhamento())
								.satisfaction(questionario.getSatisfaction())
								.observacao(questionario.getObservacao())
								.responsaveisPreenchimento(responsaveis)
								.build();
		}
}
