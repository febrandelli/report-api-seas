package com.github.seas.reportapi.config.validation;

import com.github.seas.reportapi.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorExceptionHandler {

    public static final String MENSAGEM_GLOBAL_400 = "Requisição inválida.";

    public static final String MENSAGEM_GLOBAL_401 = "Não autorizado.";

    public static final String MENSAGEM_GLOBAL_403 = "Não permitido.";

    public static final String MENSAGEM_GLOBAL_404 = "Recurso não encontrado.";

    public static final String MENSAGEM_GLOBAL_409 = "Objeto já existente.";

    public static final String MENSAGEM_GLOBAL_412 = "Pré condições não atendidas.";

    public static final String MENSAGEM_GLOBAL_500 = "Erro interno do sistema.";

    private static final String FALHA_NO_REQUEST_MSG_PATTERN = "Falha no request: Objeto[%s] Campo[%s] Valor[%s]";
    private final MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorFormDto> handle(MethodArgumentNotValidException exception){
        List<ErrorFormDto> listDto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorFormDto error = new ErrorFormDto(e.getField(), message);
            listDto.add(error);
        });
        return listDto;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundDto handle(NotFoundException exception) {
        return new NotFoundDto(exception.getMessage());
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    public InternalServerErrorDto handle(IOException exception) {
        return new InternalServerErrorDto(exception.getMessage());
    }
}
