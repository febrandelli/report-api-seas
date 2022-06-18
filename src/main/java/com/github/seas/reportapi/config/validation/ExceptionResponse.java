package com.github.seas.reportapi.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
	private String exception;
	private Timestamp timestamp;
	private String errorMessage;
}
