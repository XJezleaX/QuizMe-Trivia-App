package com.example.assignment5backend.controller;

import com.example.assignment5backend.model.Quizzes;
import com.example.assignment5backend.service.QuizzesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
public class QuizzesController {
    private final QuizzesService quizzesService;

    public QuizzesController(QuizzesService quizzesService) {
        this.quizzesService = quizzesService;
    }

    @PostMapping("/quizSelect")
    public Quizzes quizSelect(@RequestParam("quizName") String quizName) {
        return quizzesService.quizSelect(quizName);
    }

    @PostMapping("/quizSave")
    public Boolean quizSave(@RequestBody Quizzes quiz){
        return quizzesService.quizSave(quiz);
    }
}
