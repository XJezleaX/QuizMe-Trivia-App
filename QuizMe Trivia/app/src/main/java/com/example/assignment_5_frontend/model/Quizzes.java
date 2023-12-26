package com.example.assignment_5_frontend.model;

public class Quizzes {
    private Long Id;     //Variables needed
    private String quizName;

    private String description;

    public Long getId() {
        return Id;
    }  //Getter and setter for everything

    public void setId(Long id) {
        Id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
