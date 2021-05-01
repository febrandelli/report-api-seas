package com.github.seas.reportapi.controller.dto;

import com.github.seas.reportapi.domain.Perfil;
import com.github.seas.reportapi.domain.Usuario;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {
    private Long id;
    private String nomeCompleto;
    private String email;
    private String usuario;
    private List<Perfil> perfis;

    public UserResponseDto(Usuario user){
        this.id = user.getId();
        this.nomeCompleto = user.getNomeCompleto();
        this.email = user.getEmail();
        this.usuario = user.getUsername();
        this.perfis = user.getPerfis();
    }
}
