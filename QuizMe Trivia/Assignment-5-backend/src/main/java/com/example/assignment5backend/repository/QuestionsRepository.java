package com.example.assignment5backend.repository;

import com.example.assignment5backend.model.Questions;
import com.example.assignment5backend.model.Quizzes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    Questions findByQuizNameAndQuestionNum(String quizName, String questionNum);
}
