package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.dto.QuestionarioDto;
import com.github.seas.reportapi.controller.dto.QuestionarioResponse;
import com.github.seas.reportapi.controller.form.QuestionarioRequest;
import com.github.seas.reportapi.service.QuestionarioService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionario")
public class QuestionarioController implements QuestionarioDefination {

	@Autowired
	private QuestionarioService questionarioService;

	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Page<QuestionarioDto>> getAllQuestionarios(@RequestParam(value = "page", defaultValue = "0") int page,
																  @RequestParam(value = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return questionarioService.getAll(pageable);
	}

	@CrossOrigin
	@PostMapping()
	public ResponseEntity<QuestionarioResponse> create (@RequestBody QuestionarioRequest questionarioRequest) throws BadHttpRequest {
		return questionarioService.create(questionarioRequest);
	}
}
