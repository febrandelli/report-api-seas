package com.github.seas.reportapi.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InternalServerErrorDto {
    private final String message;
}
