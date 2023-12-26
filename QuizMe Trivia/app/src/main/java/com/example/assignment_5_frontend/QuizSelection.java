package com.example.assignment_5_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.assignment_5_frontend.databinding.QuizSelectionLayoutBinding;
import com.example.assignment_5_frontend.model.Questions;
import com.example.assignment_5_frontend.model.Quizzes;
import com.example.assignment_5_frontend.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizSelection extends AppCompatActivity {
    QuizSelectionLayoutBinding quizSelectionLayoutBinding;
    private QuizService service;
    private String quizName;
    private int current = 1;  //Will track the question we are on

    private int score = 0;  //Score before we compare with backend

    private Button quizOne, quizTwo, quizThree, quizFour, startbtn, returnbtn, playAgainbtn, choiceOnebtn, choiceTwobtn, choiceThreebtn, choiceFourbtn; //Will equal our button id's on layout

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizSelectionLayoutBinding = QuizSelectionLayoutBinding.inflate(getLayoutInflater());
        setContentView(quizSelectionLayoutBinding.getRoot());

        Retrofit retrofit = new Retrofit.Builder()                 //Using retrofit once again to connect with backend
                .baseUrl("http://10.0.0.216:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(QuizService.class);
        quizOne = findViewById(R.id.quiz1);          //Getting the id's for all our buttons
        quizTwo = findViewById(R.id.quiz2);
        quizThree = findViewById(R.id.quiz3);
        quizFour = findViewById(R.id.quiz4);
        startbtn = findViewById(R.id.start);
        playAgainbtn = findViewById(R.id.playAgain);
        choiceOnebtn = findViewById(R.id.choiceOne);
        choiceTwobtn = findViewById(R.id.choiceTwo);
        choiceThreebtn = findViewById(R.id.choiceThree);
        choiceFourbtn = findViewById(R.id.choiceFour);
        returnbtn = findViewById(R.id.returnLabel);

        quizOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizName = "Book Trivia";                              //Quiz one is labelled book trivia
                Call<Quizzes> response = service.quizSelect(quizName);
                response.enqueue(new Callback<Quizzes>() {
                    @Override
                    public void onResponse(Call<Quizzes> call, Response<Quizzes> response) {
                        if (response.body() != null) {                                 //If we have "Book Trivia" in our database
                            String quizInfo = response.body().getDescription();        //Get the description for the quiz for our user
                            quizSelectionLayoutBinding.quizDescription.setText(quizInfo);    //Set our text to the backends quizInfo column for "Book Trivia"
                            quizSelectionLayoutBinding.quizDescription.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.start.setVisibility(View.VISIBLE);          //Making our start button visible to viewers
                            quizSelectionLayoutBinding.selectionMessage.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz1.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.returnLabel.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.frames.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.quiz2.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz3.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz4.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Quizzes> call, Throwable t) {
                        System.out.println("Error");      //Friendly error message to account for failures in connecting
                    }
                });

            }
        });

        quizTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizName = "Sports Trivia";            //Button two is labelled "Sports Trivia" for quizTwo
                Call<Quizzes> response = service.quizSelect(quizName);
                response.enqueue(new Callback<Quizzes>() {
                    @Override
                    public void onResponse(Call<Quizzes> call, Response<Quizzes> response) {
                        if (response.body() != null) {          //If we have "Sports Trivia" in our backend SQL database
                            String quizInfo = response.body().getDescription();       //Get the quiz description from backend
                            quizSelectionLayoutBinding.quizDescription.setText(quizInfo);  //Set our text equal to quizInfo so we may display the quiz description
                            quizSelectionLayoutBinding.quizDescription.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.start.setVisibility(View.VISIBLE);     //Start will now be a visible button for users to click and begin
                            quizSelectionLayoutBinding.returnLabel.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.selectionMessage.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.frames.setVisibility(View.VISIBLE);//Original selection message and buttons for quiz options will become invisible
                            quizSelectionLayoutBinding.quiz1.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz2.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz3.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz4.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Quizzes> call, Throwable t) {  //Friendly error message
                        System.out.println("Error");
                    }
                });

            }
        });

        quizThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizName = "Movie Trivia";                    //Quiz three button has quizName "Movie Trivia"
                Call<Quizzes> response = service.quizSelect(quizName);
                response.enqueue(new Callback<Quizzes>() {
                    @Override
                    public void onResponse(Call<Quizzes> call, Response<Quizzes> response) {
                        if (response.body() != null) {                          //If we have "Movie Trivia" in our SQL database on the backend
                            String quizInfo = response.body().getDescription();        //Get the description of our quiz from the backend
                            quizSelectionLayoutBinding.quizDescription.setText(quizInfo);      //Set our text equal to the description so viewers may see info on the quiz
                            quizSelectionLayoutBinding.quizDescription.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.start.setVisibility(View.VISIBLE);       //Start buttons become visible so viewers can now click to start
                            quizSelectionLayoutBinding.returnLabel.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.selectionMessage.setVisibility(View.INVISIBLE); //We already picked a quiz so hide all other buttons for quiz option and selection method text
                            quizSelectionLayoutBinding.frames.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.quiz1.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz2.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz3.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz4.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Quizzes> call, Throwable t) { //Friendly error message
                        System.out.println("Error");
                    }
                });

            }
        });


        quizFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizName = "Video-Game Trivia";                       //Quiz four button has quizName "Video-Game Trivia"
                Call<Quizzes> response = service.quizSelect(quizName);
                response.enqueue(new Callback<Quizzes>() {
                    @Override
                    public void onResponse(Call<Quizzes> call, Response<Quizzes> response) {
                        if (response.body() != null) {                           //If we have "Video-Game Trivia" as a quiz in our database
                            String quizInfo = response.body().getDescription(); //Get the description of our quiz from the database
                            quizSelectionLayoutBinding.quizDescription.setText(quizInfo);     //Set our text equal to the description obtained so viewers may see it
                            quizSelectionLayoutBinding.quizDescription.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.start.setVisibility(View.VISIBLE);    //Start button will become visible so viewers may click to initiate quiz
                            quizSelectionLayoutBinding.returnLabel.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.selectionMessage.setVisibility(View.INVISIBLE);  //Hide the original buttons for quiz selection and text since we already picked a quiz
                            quizSelectionLayoutBinding.frames.setVisibility(View.VISIBLE);
                            quizSelectionLayoutBinding.quiz1.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz2.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz3.setVisibility(View.INVISIBLE);
                            quizSelectionLayoutBinding.quiz4.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Quizzes> call, Throwable t) {  //Friendly error message
                        System.out.println("Error");
                    }
                });

            }
        });
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //If return button is hit return to quiz selection as user wants to pick another
                Intent intent = new Intent(getBaseContext(), QuizSelection.class);
                startActivity(intent);
            }
        });

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizSelectionLayoutBinding.frames.setVisibility(View.INVISIBLE);
                display();  //Once start is clicked initiate the display method for first question of quiz selected
            }
        });
        display();  //Initiate display to run through all questions for quiz selected
    }

    private void display() {
        String questionNum = String.valueOf(current);       //Questions number wll start at current = 1 as that is the first question
        Call<Questions> response = service.allQuestions(quizName, questionNum);
        response.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                if (response.body() != null) {                                   //If the response.body() is not empty we have a entry with the quizName and questionNumber attached to it
                    quizSelectionLayoutBinding.quizDescription.setVisibility(View.INVISIBLE); //Set the quizDescription and start button invisible as quiz has started already
                    quizSelectionLayoutBinding.start.setVisibility(View.INVISIBLE);
                    quizSelectionLayoutBinding.returnLabel.setVisibility(View.INVISIBLE);
                    quizSelectionLayoutBinding.questionLabel.setVisibility(View.VISIBLE);


                    String correct = response.body().getCorrectAnswer();  //Making a String variable equal to the backends column for correct answer in our SQL database
                    String question = response.body().getQuestions();  //Getting question from backend
                    String choiceOne = response.body().getChoiceOne();  //Getting possible answers from backend
                    String choiceTwo = response.body().getChoiceTwo();
                    String choiceThree = response.body().getChoiceThree();
                    String choiceFour = response.body().getChoiceFour();
                    quizSelectionLayoutBinding.questionDescription.setText(question); //Setting our text equal to questions we got from backend
                    quizSelectionLayoutBinding.choiceOne.setText(choiceOne);  //Setting our text equal to first choice
                    final String answer1 = quizSelectionLayoutBinding.choiceOne.getText().toString();
                    quizSelectionLayoutBinding.choiceTwo.setText(choiceTwo);  //Setting our text equal to second choice
                    final String answer2 = quizSelectionLayoutBinding.choiceTwo.getText().toString();
                    quizSelectionLayoutBinding.choiceThree.setText(choiceThree); //Setting our text equal to third choice
                    final String answer3 = quizSelectionLayoutBinding.choiceThree.getText().toString();
                    quizSelectionLayoutBinding.choiceFour.setText(choiceFour);   //Setting our text equal to fourth choice
                    final String answer4 = quizSelectionLayoutBinding.choiceFour.getText().toString();
                    quizSelectionLayoutBinding.questionDescription.setVisibility(View.VISIBLE); //Make everything visible so user can see question and view possible answers
                    quizSelectionLayoutBinding.choiceOne.setVisibility(View.VISIBLE);
                    quizSelectionLayoutBinding.choiceTwo.setVisibility(View.VISIBLE);
                    quizSelectionLayoutBinding.choiceThree.setVisibility(View.VISIBLE);
                    quizSelectionLayoutBinding.choiceFour.setVisibility(View.VISIBLE);

                    choiceOnebtn.setOnClickListener(new View.OnClickListener() { //Accounting for if choiceOne button is clicked
                        @Override
                        public void onClick(View view) {
                            boolean isCorrect = answer1.equals(correct);  //Checking if the string in choiceOne matches the correctAnswer from backend
                            if (isCorrect) {      //If correct increment score and give user friendly message
                                score++;
                                Message("Correct!");
                            } else {
                                Message("Wrong answer.");  //If wrong don't increment and give user friendly message
                            }
                            current++;  //Either way increment question number and display next question and answer choices with it
                            display();
                        }
                    });
                    choiceTwobtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            boolean isCorrect = answer2.equals(correct); //Checking if the string in choiceTwo matches the correctAnswer from backend
                            if (isCorrect) {      //If correct increment score and give user friendly message
                                score++;
                                Message("Correct!");
                            } else {
                                Message("Wrong answer."); //If wrong don't increment and give user friendly message
                            }
                            current++; //Either way increment question number and display next question and answer choices with it
                            display();

                        }
                    });
                    choiceThreebtn.setOnClickListener(new View.OnClickListener() { //Accounting for choiceThree being clicked
                        @Override
                        public void onClick(View view) {
                            boolean isCorrect = answer3.equals(correct); //Checking if the string in choiceThree matches the correctAnswer from backend
                            if (isCorrect) {            //If correct increment score and give user friendly message
                                score++;
                                Message("Correct!");
                            } else {       //If wrong don't increment and give user friendly message
                                Message("Wrong answer.");
                            }
                            current++;     //Either way increment question number and display next question and answer choices with it
                            display();
                        }
                    });

                    choiceFourbtn.setOnClickListener(new View.OnClickListener() { //If choiceFourbtn is clicked
                        @Override
                        public void onClick(View view) {
                            boolean isCorrect = answer4.equals(correct); //Checking if the string in choiceThree matches the correctAnswer from backend
                            if (isCorrect) {        //If correct increment score and give user friendly message
                                score++;
                                Message("Correct!");
                            } else {
                                Message("Wrong answer.");  //User friendly message
                            }
                            current++;       //Either way increment question number and display next question and answer choices with it
                            display();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {  //Friendly errory message
                System.out.println("Error");
            }
        });

        if (current == 6) {    //When current equals 6 were at the end since each quiz only has five questions
            choiceOnebtn.setVisibility(View.INVISIBLE);       //Make all buttons invisible since we've reached the end
            choiceTwobtn.setVisibility(View.INVISIBLE);
            choiceThreebtn.setVisibility(View.INVISIBLE);
            choiceFourbtn.setVisibility(View.INVISIBLE);
            quizSelectionLayoutBinding.corgi.setVisibility(View.VISIBLE);
            quizSelectionLayoutBinding.playAgain.setVisibility(View.VISIBLE);
            quizSelectionLayoutBinding.questionLabel.setVisibility(View.INVISIBLE);
            quizSelectionLayoutBinding.frames.setVisibility(View.INVISIBLE);
            quizSelectionLayoutBinding.complete.setVisibility(View.VISIBLE);
            quizSelectionLayoutBinding.questionDescription.setText("Quiz Completed! *COMPLETE* : \n\nYour score is " + score); //User friendly quiz ended message with user score

            playAgainbtn.setOnClickListener(new View.OnClickListener() { //If play again is clicked go to quiz selection
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), QuizSelection.class);
                    startActivity(intent);
                }
            });
        }
    }



    private void Message(String message) { //Message box for our user friendly correct or wrong answer display
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
