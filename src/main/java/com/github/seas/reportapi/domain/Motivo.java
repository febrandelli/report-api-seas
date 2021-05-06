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
@Table(name = "MOTIVOS")
public class Motivo {

    @Id
    private Integer id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Override
    public String toString(){
        return this.descricao;
    }

}
