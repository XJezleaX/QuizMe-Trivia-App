package com.example.assignment5backend.controller;

import com.example.assignment5backend.model.Questions;
import com.example.assignment5backend.service.QuestionsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PostMapping("/questionSave")
    public Boolean quizSave(@RequestBody Questions question){
        return questionsService.questionSave(question);
    }

    @PostMapping("/allQuestions")
    public Questions allQuestions(@RequestParam("quizName") String quizName, @RequestParam("questionNum") String questionNum) {
        return questionsService.allQuestions(quizName, questionNum);
    }
}
