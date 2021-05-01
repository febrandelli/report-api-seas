package com.github.seas.reportapi.controller.form;

import com.github.seas.reportapi.domain.Usuario;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateForm {

    @NotEmpty
    @NotNull
    private Long id;
    @NotNull
    @NotEmpty
    private String nomeCompleto;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String usuario;

    private String senha;

    public Usuario createUser(Usuario userExist, PasswordEncoder encoder){
        Usuario user = new Usuario();
        user.setId(this.id);
        user.setNomeCompleto(this.nomeCompleto);
        user.setEmail(this.email);
        user.setUserName(this.usuario);
        if (this.getSenha() == null || this.getSenha().isEmpty()) {
            user.setSenha(userExist.getSenha());
            return user;
        }
        user.setSenha(encoder.encode(this.senha));
        return user;
    }
}
