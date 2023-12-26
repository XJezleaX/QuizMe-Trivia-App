package com.example.assignment5backend.service.impl;

import com.example.assignment5backend.model.Quizzes;
import com.example.assignment5backend.repository.QuizzesRepository;
import com.example.assignment5backend.service.QuizzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizzesServiceImpl implements QuizzesService {
    private QuizzesRepository quizzesRepository;
    @Autowired
    public void setQuizzesRepository(QuizzesRepository quizzesRepository) {
        this.quizzesRepository = quizzesRepository;
    }
    @Override
    public boolean quizSave(Quizzes quiz) {
        try {
            quizzesRepository.save(quiz);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Quizzes quizSelect(String quizName) {
        Quizzes quiz = quizzesRepository.findByQuizName(quizName);
        if (quiz != null){
            return quiz;
        } else {
            return null;
        }
    }
}
