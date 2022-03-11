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
@Table(schema = "report_api_seas", name = "MOTIVOS")
public class Motivo {

    @Id
    private Integer id;

    @Column(name = "NOMECLATURA")
    private String nomeclatura;

    @Override
    public String toString(){
        return this.nomeclatura;
    }

}
