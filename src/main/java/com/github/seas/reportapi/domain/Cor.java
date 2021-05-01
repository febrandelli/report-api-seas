package com.github.seas.reportapi.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Cor {

    @Id
    private Integer id;
    private String nomeclatura;

    @Override
    public String toString() {
        return this.nomeclatura;
    }
}
