package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.dto.DocumentTypeDto;
import com.github.seas.reportapi.domain.enums.DocumentTypeEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/documentType")
public class DocumentTypeController {
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<DocumentTypeDto>> getAllDocumentType() {
		return ResponseEntity.ok(DocumentTypeEnum.getAllDocumentType().stream()
				.map(DocumentTypeDto::new).collect(Collectors.toList()));
	}
}