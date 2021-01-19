package com.github.seas.reportapi.controller.form;

import com.github.seas.reportapi.domain.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateForm {

    @NotEmpty
    @NotNull
    private String id;
    @NotNull
    @NotEmpty
    private String nomeCompleto;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String usuario;

    private String senha;

    public User createUser(User userExist, PasswordEncoder encoder){
        User user = new User();
        user.setId(this.id);
        user.setNomeCompleto(this.nomeCompleto);
        user.setEmail(this.email);
        user.setUsuario(this.usuario);
        if (this.getSenha() == null || this.getSenha().isEmpty()) {
            user.setSenha(userExist.getSenha());
            return user;
        }
        user.setSenha(encoder.encode(this.senha));
        return user;
    }
}
