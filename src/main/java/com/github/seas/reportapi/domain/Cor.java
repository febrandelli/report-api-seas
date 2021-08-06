package com.github.seas.reportapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cor {

    @Id
    private Integer id;

    @Column(name = "NOMECLATURA")
    private String nomeclatura;

    @Override
    public String toString() {
        return this.nomeclatura;
    }
}
