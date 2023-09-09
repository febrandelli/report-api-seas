package com.github.seas.reportapi.domain.dto;

import com.github.seas.reportapi.domain.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadaoDto {

    private Long id;
    private String nome;
    private String nomePai;
    private String nomeMae;
    private DocumentTypeEnum tipoDocumento;
    private String numeroDocumento;
    private LocalDate dataNascimento;
    private GenericDto sexo;
    private GenericDto cor;
    private CidadeDto cidadeNascimento;
    private GenericDto fonteDeRenda;
    private Boolean querSairDasRuas;
    private String precisaParaSairRua;
    private List<GenericDto> motivos = new ArrayList<>();
    private List<GenericDto> casosEspeciais = new ArrayList<>();
    private List<GenericDto> beneficios = new ArrayList<>();
}
