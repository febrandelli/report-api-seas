package com.github.seas.reportapi.service;

import com.github.seas.reportapi.config.security.Service.TokenService;
import com.github.seas.reportapi.controller.dto.TokenDto;
import com.github.seas.reportapi.controller.form.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    public ResponseEntity<TokenDto> autenticar(LoginForm form) {
        UsernamePasswordAuthenticationToken tokenFormLogin = form.toToken();
        try {
            Authentication authentication = authManager.authenticate(tokenFormLogin);
            String tokenAuthentication = tokenService.createToken(authentication);
            return new ResponseEntity<>(new TokenDto(tokenAuthentication, "Bearer"), HttpStatus.OK);
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
