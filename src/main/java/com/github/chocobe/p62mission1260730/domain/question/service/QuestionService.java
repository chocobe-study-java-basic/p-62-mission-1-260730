package com.github.chocobe.p62mission1260730.domain.question.service;

import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import com.github.chocobe.p62mission1260730.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    
}
