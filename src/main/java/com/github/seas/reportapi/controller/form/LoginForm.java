package com.github.seas.reportapi.controller.form;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginForm {
    private String usuario;
    private String senha;

    public UsernamePasswordAuthenticationToken toToken() {
        return new UsernamePasswordAuthenticationToken(this.usuario, this.senha);
    }
}
