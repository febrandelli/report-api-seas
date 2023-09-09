package com.github.seas.reportapi.domain;

import com.github.seas.reportapi.domain.enums.MotivoAbordagemEnum;
import com.github.seas.reportapi.domain.enums.PeriodoJundiaiEnum;
import com.github.seas.reportapi.domain.enums.SatisfactionEnum;
import lombok.AllArgsConstructor;
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
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "report_api_seas",
				name = "QUESTIONARIO")
public class Questionario {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "NUMERO_CHAMADO")
		private Integer numeroChamado;

		@ManyToOne
		@JoinColumn(name = "ID_CIDADAO")
		private Cidadao cidadao;

		@Column(name = "MOTIVO_ABORDAGEM")
		private MotivoAbordagemEnum motivoAbordagem;

		@Column(name = "DT_INSERT")
		private LocalDateTime dtInsert;

		@Column(name = "DT_UPDATE")
		private LocalDateTime dtUpdate;

		@Column(name = "LOCAL")
		private String local;

		@Column(name = "CIRCULACAO_PELA_CIDADE")
		private String circulacaoPelaCidade;

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "ID_CIDADE_ORIGEM")
		private Cidade cidadeOrigem;

		@Column(name = "COMO_SE_VE_NA_RUA_E_FORA")
		private String comoSeVeNaRuaEFora;

		@Column(name = "PROJETO_DE_VIDA")
		private String projetoDeVida;

		@Column(name = "TEMPO_JUNDIAI")
		private PeriodoJundiaiEnum tempoJundiai;

		@Column(name = "TEMPO_SITUACAO_DE_RUA")
		private PeriodoJundiaiEnum tempoSituacaoRua;

		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(schema = "report_api_seas",
						name = "questionario_servico",
						joinColumns = {@JoinColumn(name = "questionario_id")},
						inverseJoinColumns = {@JoinColumn(name = "servico_id")})
		private Set<Servico> servicoBuscaJundiai;

		@Column(name = "EQUIPE_COMPOSTA")
		private String equipeComposta;

		@Column(name = "QT_PESSOAS_ABORDADAS")
		private Integer qtPessoasAbordadas;

		@Column(name = "QT_PESSOAS_VISUALIZADAS")
		private Integer qtPessoasVisualizadas;

		@Column(name = "RELATO_ABORDAGEM")
		private String relatoAbordagem;

		@Column(name = "SERVICO_ACIONADO")
		private String servicoAcionado;

		@Column(name = "ORIENTACAO")
		private String orientacao;

		@Column(name = "ENCAMINHAMENTO")
		private String encaminhamento;

		@Column(name = "SATISFACAO")
		private SatisfactionEnum satisfaction;

		@Column(name = "OBSERVACAO")
		private String observacao;

		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(schema = "report_api_seas",
						name = "questionario_usuario",
						joinColumns = {@JoinColumn(name = "questionario_id")},
						inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
		private Set<Usuario> responsavelPreenchimento;
}
