package com.github.chocobe.p62mission1260730.domain.question.controller;

import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import com.github.chocobe.p62mission1260730.domain.question.repository.QuestionRepository;
import com.github.chocobe.p62mission1260730.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

}
