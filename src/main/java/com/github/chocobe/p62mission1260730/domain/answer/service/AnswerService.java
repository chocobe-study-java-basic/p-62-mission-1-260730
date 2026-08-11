package com.github.chocobe.p62mission1260730.domain.answer.service;

import com.github.chocobe.p62mission1260730.domain.answer.entity.Answer;
import com.github.chocobe.p62mission1260730.domain.answer.repository.AnswerRepository;
import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);

        this.answerRepository.save(answer);
    }

}
