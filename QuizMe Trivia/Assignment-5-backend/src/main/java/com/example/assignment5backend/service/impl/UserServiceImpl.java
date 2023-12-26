package com.example.assignment5backend.service.impl;
import com.example.assignment5backend.model.Questions;
import com.example.assignment5backend.model.Quizzes;
import com.example.assignment5backend.model.User;
import com.example.assignment5backend.repository.QuestionsRepository;
import com.example.assignment5backend.repository.QuizzesRepository;
import com.example.assignment5backend.repository.UserRepository;
import com.example.assignment5backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean signup(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null){
            return user;
        } else {
            return null;
        }
    }
}
