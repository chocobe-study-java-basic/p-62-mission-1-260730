package com.github.chocobe.p62mission1260730.domain.answer.controller;

import com.github.chocobe.p62mission1260730.domain.answer.service.AnswerService;
import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import com.github.chocobe.p62mission1260730.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(
            Model model,
            @PathVariable Integer id,
            @RequestParam String content
    ) {
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);

        return "redirect:/question/detail/%d".formatted(id);
    }

}
