package com.github.seas.reportapi.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Beneficio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOMECLATURA")
    private String nomeclatura;

    @Override
    public String toString(){
        return this.nomeclatura;
    }
}
