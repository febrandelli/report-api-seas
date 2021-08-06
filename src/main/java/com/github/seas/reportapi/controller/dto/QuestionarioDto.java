package com.github.seas.reportapi.controller.dto;

import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasoEspecial;
import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.domain.Servico;
import com.github.seas.reportapi.domain.Usuario;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class QuestionarioDto {

	private long id;
	private String data;
	private String dataAtualizacao;
	private String local;
	private String motivoAbordagem;
	private String nomeAbordado;
	private String dataNascimentoAbordado;
	private long idadeAbordado;
	private String sexo;
	private String cor;
	private String cidadeNascimento;
	private String cidadeOrigem;
	private String tempoEmJundiai;
	private String tempoSituacaoRua;
	private List<String> motivoLevouRua;
	private boolean querSairRua;
	private String oquePrecisaParaSairRua;
	private List<String> servicoQueBusca;
	private String principalMeioSobrevivencia;
	private List<String> recebeBeneficios;
	private List<String> casosEspeciais;
	private List<String> responsaveisPeloPreenchimento;
	private String observacao;

	public QuestionarioDto(Questionario questionario) {
		this.id = questionario.getId();
		this.data = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(Date.from(questionario.getDtInsert().toInstant(ZoneOffset.UTC)));
		this.dataAtualizacao = questionario.getDtUpdate() == null ? new SimpleDateFormat("yyyy-MM-dd hh:mm").format(Date.from(questionario.getDtInsert().toInstant(ZoneOffset.UTC))) : new SimpleDateFormat("yyyy-MM-dd hh:mm").format(Date.from(questionario.getDtUpdate().toInstant(ZoneOffset.UTC)));
		this.local = questionario.getLocal();
		this.motivoAbordagem = questionario.getMotivoAbordagem().toString();
		this.nomeAbordado = questionario.getCidadao().getNome();
		this.dataNascimentoAbordado = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(questionario.getCidadao().getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		this.idadeAbordado = questionario.getCidadao().getDataNascimento().until(LocalDate.now(), ChronoUnit.YEARS);
		this.sexo = questionario.getCidadao().getSexo().toString();
		this.cor = questionario.getCidadao().getCor().toString();
		this.cidadeNascimento = questionario.getCidadao().getCidadeNascimento().toString();
		this.cidadeOrigem = questionario.getCidadeOrigem().toString();
		this.tempoEmJundiai = questionario.getTempoJundiai().toString();
		this.tempoSituacaoRua = questionario.getTempoSituacaoRua().toString();
		this.motivoLevouRua = questionario.getCidadao().getMotivos().stream().map(Motivo::getNomeclatura).collect(Collectors.toList());
		this.querSairRua = questionario.getCidadao().getQuerSairDasRuas();
		this.oquePrecisaParaSairRua = questionario.getCidadao().getPrecisaParaSairRua();
		this.servicoQueBusca = questionario.getServicoBuscaJundiai().stream().map(Servico::getNomeclatura).collect(Collectors.toList());
		this.principalMeioSobrevivencia = questionario.getCidadao().getFonteDeRenda().toString();
		this.recebeBeneficios = questionario.getCidadao().getBeneficios().stream().map(Beneficio::getNomeclatura).collect(Collectors.toList());
		this.casosEspeciais = questionario.getCidadao().getCasosEspeciais().stream().map(CasoEspecial::getNomeclatura).collect(Collectors.toList());
		this.responsaveisPeloPreenchimento = questionario.getResponsavelPreenchimento().stream().map(Usuario::getNomeCompleto).collect(Collectors.toList());
		this.observacao = questionario.getObservacao();
	}
}
