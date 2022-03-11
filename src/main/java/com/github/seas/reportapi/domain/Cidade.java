package com.github.seas.reportapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "report_api_seas", name = "CIDADES")
public class Cidade {

    @Id
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    @Override
    public String toString(){
        return this.nome + " - " + this.estado.getUF();
    }
}
