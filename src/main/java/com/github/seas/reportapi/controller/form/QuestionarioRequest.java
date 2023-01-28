package com.github.seas.reportapi.controller.form;

import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import com.github.seas.reportapi.domain.enums.SatisfactionEnum;
import lombok.Data;

import java.util.List;

@Data
public class QuestionarioRequest {

	private Long idCidadao;
	private Long idCidadeOrigem;
	private String local;
	private MotivoAbordagemEnum motivoAbordagem;
	private Integer numeroChamado;
	private String circulacaoPelaCidade;
	private PeriodoJundiaiEnum tempoJundiai;
	private PeriodoJundiaiEnum tempoSituacaoDeRua;
	private String comoSeVeNaRuaEFora;
	private String projetoDeVida;
	private List<Long> servicoBuscaJundiai;
	private String combinados;
	private String equipeComposta;
	private Integer pessoasAbordadas;
	private Integer pessoasVisualizadas;
	private String descricao;
	private String acionouOutroServico;
	private String orientacoes;
	private String encaminhadoPara;
	private SatisfactionEnum pesquisaDeSatisfacao;
	private String observacao;
	private List<Long> responsavelPreenchimento;
}
