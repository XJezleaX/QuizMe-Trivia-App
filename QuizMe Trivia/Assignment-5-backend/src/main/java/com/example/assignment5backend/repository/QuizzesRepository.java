package com.example.assignment5backend.repository;

import com.example.assignment5backend.model.Quizzes;
import com.example.assignment5backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzesRepository extends JpaRepository<Quizzes, Long> {
    Quizzes findByQuizName(String quizName);
}
