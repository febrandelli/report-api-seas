package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.config.validation.ErrorExceptionHandler;
import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.exception.ErroInfo;
import com.github.seas.reportapi.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(value = "Cidade", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Cidades"})
public interface CidadeDefinition {

    @ApiOperation(value = "Listar todas cidades por Estado(UF)")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<List<Cidade>> getAllCidades(Integer estado) throws NotFoundException;
}
