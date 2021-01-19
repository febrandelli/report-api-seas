package com.github.seas.reportapi.controller.dto;

import com.github.seas.reportapi.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String id;
    private String nomeCompleto;
    private String email;
    private String usuario;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.nomeCompleto = user.getNomeCompleto();
        this.email = user.getEmail();
        this.usuario = user.getUsuario();
    }
}
