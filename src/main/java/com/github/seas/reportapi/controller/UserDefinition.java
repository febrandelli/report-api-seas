package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.config.validation.ErrorExceptionHandler;
import com.github.seas.reportapi.domain.dto.UserResponseDto;
import com.github.seas.reportapi.controller.form.ResetPasswordRequest;
import com.github.seas.reportapi.controller.form.UserCreateForm;
import com.github.seas.reportapi.controller.form.UserUpdateForm;
import com.github.seas.reportapi.controller.response.ResetPasswordResponse;
import com.github.seas.reportapi.exception.ErroInfo;
import com.github.seas.reportapi.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(value = "Usuários", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Usuários"})
public interface UserDefinition {

    @ApiOperation(value = "Listar todos os usuários")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<List<UserResponseDto>> getUsers() ;

    @ApiOperation(value = "Buscar usuário por Id")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<UserResponseDto> getUser(Long idUsuario) throws NotFoundException;

    @ApiOperation(value = "Criar um novo usuário")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<UserResponseDto> createUser(UserCreateForm userCreate);

    @ApiOperation(value = "Atualizar usuário")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<UserResponseDto> updateUser(UserUpdateForm userUpdate) throws NotFoundException;

    @ApiOperation(value = "Deleta usuário por Id")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<UserResponseDto> deleteUser(Long id) throws NotFoundException;

    @ApiOperation(value = "Reseta a senha e envia email com nova senha")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<ResetPasswordResponse> resetPassword(ResetPasswordRequest email) throws NotFoundException;
}
