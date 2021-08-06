package com.github.seas.reportapi.utils;

import com.github.seas.reportapi.controller.dto.QuestionarioDto;
import com.github.seas.reportapi.domain.Questionario;
import org.springframework.core.convert.converter.Converter;

public class QuestionarioConverter implements Converter<Questionario, QuestionarioDto> {
	@Override
	public QuestionarioDto convert(Questionario questionario) {
		return new QuestionarioDto(questionario);
	}
}
