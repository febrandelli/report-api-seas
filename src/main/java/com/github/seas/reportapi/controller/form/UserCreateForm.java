package com.github.seas.reportapi.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserCreateForm {
    @NotNull @NotEmpty
    private String nomeCompleto;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String usuario;

    @NotNull @NotEmpty
    private String senha;
}
