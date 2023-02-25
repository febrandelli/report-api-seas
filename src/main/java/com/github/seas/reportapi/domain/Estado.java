package com.github.seas.reportapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "report_api_seas", name = "ESTADOS")
public class Estado {

    @Id
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "UF")
    private String uf;
}
