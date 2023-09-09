package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.config.validation.ErrorExceptionHandler;
import com.github.seas.reportapi.domain.dto.QuestionarioDto;
import com.github.seas.reportapi.exception.ErroInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.tools.web.BadHttpRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api(value = "Questionarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Questionarios"})
public interface QuestionarioDefination {

	@ApiOperation(value = "Listar todos os questionarios")
	@ApiResponses({
			@ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
	public ResponseEntity<Page<QuestionarioDto>> getAllQuestionarios(int page, int size);

	@ApiOperation(value = "Registra um novo questionario")
	@ApiResponses({
			@ApiResponse(code = 400, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 404, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = ErrorExceptionHandler.MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
	public ResponseEntity<QuestionarioDto> create (QuestionarioDto questionarioDto) throws BadHttpRequest;
}
