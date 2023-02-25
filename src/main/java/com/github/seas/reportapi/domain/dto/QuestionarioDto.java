package com.github.seas.reportapi.domain.dto;

import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import com.github.seas.reportapi.domain.enums.SatisfactionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionarioDto {

		private long id;
		private Integer numeroChamado;
		private CidadaoDto cidadao;
		private MotivoAbordagemEnum motivoAbordagem;
		private LocalDateTime dtInsert;
		private LocalDateTime dtUpdate;
		private String local;
		private String circulacaoPelaCidade;
		private CidadeDto cidadeOrigem;
		private String comoSeVeNaRuaEFora;
		private String projetoDeVida;
		private PeriodoJundiaiEnum tempoJundiai;
		private PeriodoJundiaiEnum tempoSituacaoRua;
		private List<GenericDto> servicoBuscaJundiai;
		private String equipeComposta;
		private Integer qtPessoasAbordadas;
		private Integer qtPessoasVisualizadas;
		private String relatoAbordagem;
		private String servicoAcionado;
		private String orientacao;
		private String encaminhamento;
		private SatisfactionEnum satisfaction;
		private String observacao;
		private List<String> responsaveisPreenchimento;
}
