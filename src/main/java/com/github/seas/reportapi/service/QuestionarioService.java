package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.QuestionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionarioService {

    private final QuestionarioRepository questionarioRepository;

    public Page<Questionario> listQuestionarios(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);

        return questionarioRepository.findAll(pageRequest);
    }

    public Questionario createQuestionario(Questionario questionario) {

        return questionarioRepository.insert(questionario);
    }

    public Questionario getQuestionarioById(String id) throws NotFoundException {
        Optional<Questionario> questionario = questionarioRepository.findById(id);
        if (!questionario.isPresent()) {
            throw new NotFoundException("Questionario não encontrado");
        }
        return questionario.get();
    }

    public void deleteQuestionario(String id) {
        questionarioRepository.deleteById(id);
    }

    public Questionario updateQuestionario(Questionario questionarioToUpdate) throws NotFoundException {
        Optional<Questionario> questionarioExist = questionarioRepository.findById(questionarioToUpdate.getId());
        if (!questionarioExist.isPresent()) {
            throw new NotFoundException("Questionario não encontrado");
        }
        return questionarioRepository.save(questionarioToUpdate);
    }
}
