package com.example.assignment5backend.controller;

import com.example.assignment5backend.model.Questions;
import com.example.assignment5backend.model.Quizzes;
import com.example.assignment5backend.model.User;
import com.example.assignment5backend.service.UserService;
import com.example.assignment5backend.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserServiceImpl loginService) {
        this.userService = loginService;
    }

    @PostMapping("/signup")
    public Boolean signup(@RequestBody User user){
        return userService.signup(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.login(username, password);
    }

}