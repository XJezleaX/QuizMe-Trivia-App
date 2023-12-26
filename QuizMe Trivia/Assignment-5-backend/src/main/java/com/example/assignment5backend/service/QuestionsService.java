package com.example.assignment5backend.service;

import com.example.assignment5backend.model.Questions;

public interface QuestionsService {
    boolean questionSave(Questions question);
    Questions allQuestions(String quizName, String questionNum);
}
