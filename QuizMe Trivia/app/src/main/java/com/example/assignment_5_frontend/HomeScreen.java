package com.example.assignment_5_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_5_frontend.databinding.HomeScreenLayoutBinding;
import com.example.assignment_5_frontend.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeScreen extends AppCompatActivity {
    HomeScreenLayoutBinding homeScreenLayoutBinding;
    private QuizService service;
    private Button loginbtn, signupbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                     //Getting our home screen layout
        homeScreenLayoutBinding = HomeScreenLayoutBinding.inflate(getLayoutInflater());
        setContentView(homeScreenLayoutBinding.getRoot());


        Retrofit retrofit = new Retrofit.Builder()               //Using retrofit to connect to our backend on Springboot
                .baseUrl("http://10.0.0.216:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(QuizService.class);

        loginbtn = findViewById(R.id.login);     //Getting our login and signup button for user authentication
        signupbtn = findViewById(R.id.signup);
        loginbtn.setOnClickListener(new View.OnClickListener() {   //Accounting for if login is clicked
            @Override
            public void onClick(View view) {
                String username = homeScreenLayoutBinding.username.getEditableText().toString();   //Get the username entered by user
                String password = homeScreenLayoutBinding.password.getEditableText().toString();    //Get the password entered by user
                boolean valid = validate(username, password);  //Ensure a valid entry was given by user

                if (valid) {                                             //If we do have a valid entry now we check with our backend database
                    Call<User> response = service.login(username, password);  //Making a call to our user post method and giving the parameters username and password
                    response.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.body() != null) {                                    //If we have a response.body() user is registered in our database
                                Intent intent = new Intent(getBaseContext(), QuizSelection.class); //User can continue so we load up the QuizSelection screen
                                User user = response.body();
                                intent.putExtra("username", user.getUsername());  //Passing username to other quizselection screen
                                startActivity(intent);
                                homeScreenLayoutBinding.password.setText("");
                                homeScreenLayoutBinding.username.setText("");
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            homeScreenLayoutBinding.box.setVisibility(View.VISIBLE);
                            homeScreenLayoutBinding.accountNotFound.setVisibility(View.VISIBLE);
                        }
                    });

                }
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {  //Accounting for if signup is clicked
            @Override
            public void onClick(View view) {
                String username = homeScreenLayoutBinding.username.getEditableText().toString(); //Get the username desired by user
                String password = homeScreenLayoutBinding.password.getEditableText().toString(); //Get the password desired by user
                boolean valid = validate(username, password);  //Ensure username and password are both valid entries

                if (valid) {                //If we have a valid entry make a new object class for User and give it the users password and username
                    User user = new User(
                            username,
                            password
                    );

                    Call<Boolean> response = service.signup(user); //Calling our post method signup and giving it the user object
                    response.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (true) {                                                             //If we have a response to signup, user is now signed up in our database
                                Intent intent = new Intent(getBaseContext(), QuizSelection.class); //Send user to QuizSelection screen
                                intent.putExtra("username", user.getUsername());
                                intent.putExtra("password", user.getPassword());
                                startActivity(intent);
                                homeScreenLayoutBinding.password.setText("");
                                homeScreenLayoutBinding.username.setText("");
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            System.out.println("Error");   //Accounting for errors with connecting to backend
                        }
                    });

                }
            }
        });
    }

    private boolean validate(String username, String password) {  //Setting some validation conditions
        if (username.isEmpty() && password.isEmpty()) {      //Username and password entries cannot be empty
            homeScreenLayoutBinding.username.setError("Username cannot be empty");  //User friendly message
            homeScreenLayoutBinding.password.setError("Password cannot be empty");//User friendly message
            return false;
        } else if (password.isEmpty()) {
            homeScreenLayoutBinding.password.setError("Password cannot be empty");//User friendly message
            return false;
        }
        if (password.length() < 8) { //Password cannot be less than 8 in length
            homeScreenLayoutBinding.password.setError("Password should be more than 8 characters!");//User friendly message
            System.out.println("password");
            return false;
        }

        return true;
    }
}
