package com.github.seas.reportapi.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document("questionarios")
public class Questionario {
    private String id;
    private LocalDate data;
    private String hora;
    private String localAbordagem;
    private String nomeAbordado;
    private String dataNascimento;
    private String sexo;
    private String cor;
    private String localNascimento;
    private String localOrigem;
    private String tempoJund;
    private String tempoRua;
    private List<String> motivo;
    private String sairRua;
    private String oquePrecisaSairRua;
    private List<String> servicoBusca;
    private String meioSobrevivencia;
    private List<String> beneficio;
    private List<String> casosEspeciais;
    private String equipeComposta;
    private Integer pessoasAbordadas;
    private String observacaoGeral;
    private String encaminhamento;
    private String orientacoes;
    private String responsavel;
}
