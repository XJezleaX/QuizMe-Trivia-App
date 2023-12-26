package com.example.assignment5backend.service;

import com.example.assignment5backend.model.Quizzes;

public interface QuizzesService {
    Quizzes quizSelect(String quizName);
    boolean quizSave(Quizzes quiz);
}
