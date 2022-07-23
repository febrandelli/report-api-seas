package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.config.validation.ErrorExceptionHandler;
import com.github.seas.reportapi.controller.dto.TokenDto;
import com.github.seas.reportapi.controller.form.LoginForm;
import com.github.seas.reportapi.controller.form.ValidTokenForm;
import com.github.seas.reportapi.exception.ErroInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api(value = "Autenticação", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Autenticação"})
public interface AuthenticationDefinition {

    @ApiOperation(value = "Gerar token de autenticação")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<TokenDto> authentication(LoginForm form);

    @ApiOperation(value = "Validar se token ainda está valido")
    @ApiResponses({
            @ApiResponse(code = 200, message= "Token ainda é valido"),
            @ApiResponse(code = 400, message= "Token não é mais valido"),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<?> validated(ValidTokenForm form);
}