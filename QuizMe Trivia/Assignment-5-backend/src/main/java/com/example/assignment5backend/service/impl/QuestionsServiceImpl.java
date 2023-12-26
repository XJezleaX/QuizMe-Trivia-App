package com.example.assignment5backend.service.impl;

import com.example.assignment5backend.model.Questions;
import com.example.assignment5backend.repository.QuestionsRepository;
import com.example.assignment5backend.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private QuestionsRepository questionsRepository;
    @Autowired
    public void setQuestionsRepository(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
    @Override
    public boolean questionSave(Questions question) {
        try {
            questionsRepository.save(question);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Questions allQuestions(String quizName, String questionNum) {
        Questions question = questionsRepository.findByQuizNameAndQuestionNum(quizName, questionNum);

        if (question != null){
            return question;
        } else {
            return null;
        }
    }
}
