package com.example.assignment5backend.service;

import com.example.assignment5backend.model.Questions;
import com.example.assignment5backend.model.Quizzes;
import com.example.assignment5backend.model.User;

public interface UserService {

    User login(String username, String password);

    boolean signup(User user);
}