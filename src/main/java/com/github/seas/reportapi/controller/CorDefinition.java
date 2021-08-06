package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.config.validation.ErrorExceptionHandler;
import com.github.seas.reportapi.domain.Cor;
import com.github.seas.reportapi.exception.ErroInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(value = "Cores", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Cores"})
public interface CorDefinition {

    @ApiOperation(value = "Listar todos os cores")
    @ApiResponses({
            @ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
    ResponseEntity<List<Cor>> getAllCor();
}
