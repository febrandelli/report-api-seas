package com.github.seas.reportapi.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Perfil implements GrantedAuthority {
    private String nome;

    @Override
    public String getAuthority() {
        return this.nome;
    }
}
