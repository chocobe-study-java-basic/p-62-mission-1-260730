package com.github.chocobe.p62mission1260730.domain.question.controller;

import com.github.chocobe.p62mission1260730.domain.answer.AnswerForm;
import com.github.chocobe.p62mission1260730.domain.question.QuestionForm;
import com.github.chocobe.p62mission1260730.domain.question.entity.Question;
import com.github.chocobe.p62mission1260730.domain.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            Model model,
            @PathVariable Integer id,
            @ModelAttribute AnswerForm answerForm
    ) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(
            @ModelAttribute QuestionForm questionForm
    ) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(
            @Valid @ModelAttribute QuestionForm questionForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }

        this.questionService.create(
                questionForm.getSubject(),
                questionForm.getContent()
        );

        return "redirect:/question/list";
    }

}
