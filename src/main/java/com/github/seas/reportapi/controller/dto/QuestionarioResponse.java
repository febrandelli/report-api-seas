package com.github.seas.reportapi.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuestionarioResponse {
	private Long id;
	private LocalDateTime dateRegister;
}
