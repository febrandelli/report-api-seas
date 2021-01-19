package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.dto.TokenDto;
import com.github.seas.reportapi.controller.form.LoginForm;
import com.github.seas.reportapi.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<TokenDto> authentication(@RequestBody @Valid LoginForm form){

        UsernamePasswordAuthenticationToken dadosLogin = form.toToken();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.createToken(authentication);
            return new ResponseEntity<>(new TokenDto(token, "Bearer"), HttpStatus.OK);
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
