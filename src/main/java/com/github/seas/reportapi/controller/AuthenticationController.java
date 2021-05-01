package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.dto.TokenDto;
import com.github.seas.reportapi.controller.form.LoginForm;
import com.github.seas.reportapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController implements AuthenticationDefinition{
    @Autowired
    private AuthenticationService authenticationService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<TokenDto> authentication(@RequestBody @Valid LoginForm form){
        return authenticationService.autenticar(form);
    }
}
