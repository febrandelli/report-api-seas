package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.QuestionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("questionario")
@RequiredArgsConstructor
public class QuestionarioController {

    private final QuestionarioService questionarioService;

    @GetMapping
    public ResponseEntity<Page<Questionario>> getQuestionarios(@RequestParam Integer page, @RequestParam Integer size) {
        return new ResponseEntity<>(questionarioService.listQuestionarios(page, size), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Questionario> getQuestionario(@PathVariable String id) throws NotFoundException {
        Questionario questionario = questionarioService.getQuestionarioById(id);
        return new ResponseEntity<>(questionario, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Questionario> updateQuestionario(@RequestBody Questionario questionarioToUpdate) throws NotFoundException {
        Questionario questionario = questionarioService.updateQuestionario(questionarioToUpdate);
        return new ResponseEntity<>(questionario,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Questionario> createQuestionario(@RequestBody Questionario questionario) {
        Questionario questionarioCreated = questionarioService.createQuestionario(questionario);

        return new ResponseEntity<>(questionarioCreated, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Questionario> deleteQuestionario(@PathVariable String id) throws NotFoundException {
        Questionario questionarioDeleted = questionarioService.getQuestionarioById(id);
        questionarioService.deleteQuestionario(id);

        return new ResponseEntity<>(questionarioDeleted, HttpStatus.OK);
    }

}
