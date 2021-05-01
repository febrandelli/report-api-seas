package com.github.seas.reportapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.seas.reportapi.domain.Beneficio;
import com.github.seas.reportapi.domain.CasosEspeciais;
import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.domain.FonteDeRenda;
import com.github.seas.reportapi.domain.Motivo;
import com.github.seas.reportapi.domain.Sexo;
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
    @ApiModelProperty(value = "Sexo que o cidadão se identifica")
    private Sexo sexo;

    @NotNull
    @ApiModelProperty(value = "Cor de pele do cidadão")
    private Cor cor;

    @ApiModelProperty(value = "Cidade de nascimento do cidadão")
    private Cidade cidadeNascimento;

    @ApiModelProperty(value = "Principal fonte de renda do cidadão")
    private FonteDeRenda fonteDeRenda;

    @ApiModelProperty(value = "Se o cidadão tem interesse em sair da situação de rua")
    private Boolean querSairDasRuas;

    @ApiModelProperty(value = "Os motivos que levaram o cidadão a viver em situação de rua")
    private Set<Motivo> motivos;

    @ApiModelProperty(value = "O cidadão atende a um ou mais casos especiais?")
    private Set<CasosEspeciais> casosEspeciais;

    @ApiModelProperty(value = "Quais benefícios o cidadão recebe")
    private Set<Beneficio> beneficios;
}
