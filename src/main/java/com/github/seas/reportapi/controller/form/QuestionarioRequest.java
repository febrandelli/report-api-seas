package com.github.seas.reportapi.controller.form;

import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import lombok.Data;

import java.util.List;

@Data
public class QuestionarioRequest {

	private String local;
	private Long idCidadao;
	private Long idCidade;
	private MotivoAbordagemEnum motivoAbordagem;
	private PeriodoJundiaiEnum tempoJundiai;
	private List<Long> servicoBuscaJundiai;
	private List<Long> responsavelPreenchimento;
	private PeriodoJundiaiEnum tempoSituacaoDeRua;
	private String observacao;
}
