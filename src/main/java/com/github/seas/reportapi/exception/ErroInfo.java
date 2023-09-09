package com.github.seas.reportapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Resposta de erro da API")
public class ErroInfo {

    @ApiModelProperty(value = "timestamp", notes = "Data e hora do erro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime timestamp;

    @ApiModelProperty(value = "code", notes = "Código do erro")
    public Integer code;

    @ApiModelProperty(value = "exception", notes = "Exceção lançada")
    public String exception;

    @ApiModelProperty(value = "messages", notes = "Lista de mensagens de erro")
    public List<String> messages;

    @ApiModelProperty(value = "path", notes = "Path da chamada que ocasionou o erro")
    public String path;
}