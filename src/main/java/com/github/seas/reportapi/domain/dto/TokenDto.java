package com.github.seas.reportapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenDto {
    private String token;
    private String type;
}
