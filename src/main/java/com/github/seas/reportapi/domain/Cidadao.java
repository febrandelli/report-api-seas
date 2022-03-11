package com.github.seas.reportapi.domain;

import com.github.seas.reportapi.controller.dto.CidadaoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "report_api_seas", name = "CIDADAO")
public class Cidadao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "ID_SEXO")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "ID_COR")
    private Cor cor;

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE")
    private Cidade cidadeNascimento;

    @ManyToOne
    @JoinColumn(name = "ID_PRINCIPAL_RENDA")
    private FonteDeRenda fonteDeRenda;

    @Column(name = "DESEJA_SAIR_RUA")
    private Boolean querSairDasRuas;

    @Column(name = "PRECISA_PARA_SAIR_RUA")
    private String precisaParaSairRua;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "report_api_seas", name = "cidadao_motivo", joinColumns = {
            @JoinColumn(name = "cidadao_id")}, inverseJoinColumns = {
            @JoinColumn(name = "motivo_id")
    })
    private Set<Motivo> motivos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "report_api_seas", name = "cidadao_caso_especial", joinColumns = {
            @JoinColumn(name = "cidadao_id")}, inverseJoinColumns = {
            @JoinColumn(name = "caso_especial_id")
    })
    private Set<CasoEspecial> casosEspeciais;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "report_api_seas", name = "cidadao_beneficio", joinColumns = {
            @JoinColumn(name = "cidadao_id")}, inverseJoinColumns = {
            @JoinColumn(name = "beneficio_id")
    })
    private Set<Beneficio> beneficios;
}
