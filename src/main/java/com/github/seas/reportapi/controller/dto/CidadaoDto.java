package com.github.seas.reportapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Objeto para criação de um novo cidadão")
public class CidadaoDto {

    @NotNull
    @ApiModelProperty(value = "Nome do cidadão")
    private String nome;

    @ApiModelProperty(value = "Data de nascimento", example = "1992-02-26")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Brazil/East")
    private LocalDate dataNascimento;

    @NotNull
    @ApiModelProperty(value = "Sexo que o cidadão se identifica", example = "1")
    private int sexo;

    @NotNull
    @ApiModelProperty(value = "Cor de pele do cidadão", example = "1")
    private int cor;

    @ApiModelProperty(value = "Cidade de nascimento do cidadão", example = "42")
    private long cidadeNascimento;

    @ApiModelProperty(value = "Principal fonte de renda do cidadão", example = "2")
    private int fonteDeRenda;

    @ApiModelProperty(value = "Se o cidadão tem interesse em sair da situação de rua", example = "true")
    private Boolean querSairDasRuas;

    @ApiModelProperty(value = "O que o cidadao precisa para sair da situação de rua", example = "Cidadão precisa de emprego")
    private String precisaParaSairRua;

    @ApiModelProperty(value = "Os motivos que levaram o cidadão a viver em situação de rua", example = "[1,2]")
    private Set<Integer> motivos;

    @ApiModelProperty(value = "O cidadão atende a um ou mais casos especiais?", example = "[1,2]")
    private Set<Integer> casosEspeciais;

    @ApiModelProperty(value = "Quais benefícios o cidadão recebe", example = "[1,2]")
    private Set<Integer> beneficios;
}
