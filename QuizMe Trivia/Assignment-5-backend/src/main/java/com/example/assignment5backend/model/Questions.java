package com.example.assignment5backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String quizName;

    @Column
    private String questionNum;

    @Column
    private String questions;

    @Column
    private String choiceOne;

    @Column
    private String choiceTwo;

    @Column
    private String choiceThree;

    @Column
    private String choiceFour;

    @Column
    private String correctAnswer;

}

