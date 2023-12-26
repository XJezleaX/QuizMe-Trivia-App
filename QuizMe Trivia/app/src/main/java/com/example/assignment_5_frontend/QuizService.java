package com.example.assignment_5_frontend;

import com.example.assignment_5_frontend.model.Questions;
import com.example.assignment_5_frontend.model.Quizzes;
import com.example.assignment_5_frontend.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface QuizService {
    @FormUrlEncoded
    @POST("user/login")
    Call<User> login(@Field("username") String username, @Field("password") String password);//Post to access login in our backend

    @POST("user/signup")
    Call<Boolean> signup(@Body User user); //Post to access signup method in backend
    @FormUrlEncoded
    @POST("quizzes/quizSelect")
    Call<Quizzes> quizSelect(@Field("quizName") String quizName); //Post to access the quizSelect in backend

    @FormUrlEncoded
    @POST("questions/allQuestions")
    Call<Questions> allQuestions(@Field("quizName") String quizName, @Field("questionNum") String questionNum); //Post to access allQuestions in backend
}
