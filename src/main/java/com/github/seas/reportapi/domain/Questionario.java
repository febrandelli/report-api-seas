package com.github.seas.reportapi.domain;

import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Questionario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DT_INSERT")
	private LocalDateTime dtInsert;

	@Column(name = "DT_UPDATE")
	private LocalDateTime dtUpdate;

	@Column(name = "LOCAL")
	private String local;

	@ManyToOne
	@JoinColumn(name = "ID_CIDADAO")
	private Cidadao cidadao;

	@ManyToOne
	@JoinColumn(name = "ID_CIDADE_ORIGEM")
	private Cidade cidadeOrigem;

	@Column(name = "MOTIVO_ABORDAGEM")
	private MotivoAbordagemEnum motivoAbordagem;

	@Column(name = "TEMPO_JUNDIAI")
	private PeriodoJundiaiEnum tempoJundiai;

	@Column(name = "TEMPO_SITUACAO_DE_RUA")
	private PeriodoJundiaiEnum tempoSituacaoRua;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "questionario_servico", joinColumns = {
			@JoinColumn(name = "questionario_id")}, inverseJoinColumns = {
			@JoinColumn(name = "servico_id")
	})
	private Set<Servico> servicoBuscaJundiai;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "questionario_usuario", joinColumns = {
			@JoinColumn(name = "questionario_id")}, inverseJoinColumns = {
			@JoinColumn(name = "usuario_id")
	})
	private Set<Usuario> responsavelPreenchimento;

	@Column(name = "OBSERVACAO")
	private String observacao;
}
