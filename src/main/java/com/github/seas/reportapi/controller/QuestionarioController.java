package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.dto.QuestionarioDto;
import com.github.seas.reportapi.converter.QuestionarioConverter;
import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.service.QuestionarioService;
import javassist.tools.web.BadHttpRequest;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionario")
public class QuestionarioController
				implements QuestionarioDefination {

		private final QuestionarioService questionarioService;
		private final QuestionarioConverter questionarioConverter;

		@Autowired
		public QuestionarioController(QuestionarioService questionarioService, QuestionarioConverter questionarioConverter) {
				this.questionarioService = questionarioService;
				this.questionarioConverter = questionarioConverter;
		}

		@CrossOrigin
		@GetMapping("/{id}")
		public ResponseEntity<QuestionarioDto> getAllQuestionarios(@PathVariable Long id) throws NotFound {
				return new ResponseEntity<>(questionarioConverter.toDto(questionarioService.getById(id)), HttpStatus.OK);
		}

		@CrossOrigin
		@GetMapping()
		public ResponseEntity<Page<QuestionarioDto>> getAllQuestionarios(
						@RequestParam(value = "page",
										defaultValue = "0")
										int page,
						@RequestParam(value = "size",
										defaultValue = "10")
										int size) {
				Pageable pageable = PageRequest.of(page, size);
				return questionarioService.getAll(pageable);
		}

		@CrossOrigin
		@PostMapping()
		public ResponseEntity<QuestionarioDto> create(
						@RequestBody
										QuestionarioDto questionarioDto) throws BadHttpRequest {
				Questionario newQuestionario = questionarioConverter.fromDto(questionarioDto);
				Questionario questionarioSaved = questionarioService.create(newQuestionario);
				QuestionarioDto response = questionarioConverter.toDto(questionarioSaved);
				return new ResponseEntity(response, HttpStatus.CREATED);
		}

		@CrossOrigin
		@PutMapping("/{id}")
		public ResponseEntity<QuestionarioDto> update(
						@RequestBody
										QuestionarioDto questionarioDto,
						@PathVariable
										Integer id) {
				Questionario newQuestionario = questionarioConverter.fromDto(questionarioDto);
				Questionario questionarioSaved = questionarioService.update(newQuestionario);
				QuestionarioDto response = questionarioConverter.toDto(questionarioSaved);
				return new ResponseEntity(response, HttpStatus.OK);
		}
}
