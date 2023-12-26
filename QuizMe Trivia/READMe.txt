Basic Android Quiz App with SpringBoot Backend:

QuizMe Trivia is the new version of my QuizMe application designed to test the user's knowledge, only this time with multiple quizzes to choose from! The user can choose from a selection of quizzes: "Movie Trivia", "Book Trivia", "Video-Game Trivia", and "Sports Trivia". Each quiz has a different difficulty so pick wisely!

Required Packages: Java, Maven, Retrofit 2.2.0, Springboot, MySQL and SQL workbench, Gradle (Target SK and Compile SDK changed to 34)
Programmed on: IntelliJ, Android Studio

Architectural Choices and Libraries:
I chose to use Springboot, with Maven, to design the backend with an SQL database. An SQL database is incredibly easy and efficient so I felt it best for storing the user and quiz data. In terms of Android Studio, Retrofit was great to connect to the backend as it had many functions within the library to retrieve and send user/quiz data. In terms of the architecture of the Springboot backend, I created multiple controller, service, serviceImpl, model, and repository classes. In the end, there was one set for Quizzes, one set for Questions, and one set for Users. The creation of multiple was done for organizational purposes, clarity, and good coding practices. The architecture of the Android Studio had a Home Screen fragment and Quiz Selection fragment as user authentication needed to connect to the User table and seemed more clear to put on its own fragment. The Quiz Selection connected to the quizzes table and question table but related as they were both giving quiz data, as such I placed them in one fragment for simplicity.

Building/Compiling the Application: 
This can be used on any Android device or through an emulator. This program was tested using Android Studio's emulator, specifically the Pixel 6 API 31 phone. To set up a device emulator go to Device Manager in Android Studio and click Create Device. You may choose to use the same setup as me and download the S package for it, or pick another device option. Keep in mind for retrofit the base URL must be changed to the IP address on your device. Before running the application on Android Studio you must load the backend portion into Intellij. Once you run the backend portion, return to Android Studio, run the program, and the main screen will appear.

Once the program begins sign up if it is your first time or login. Once you have done so you will be taken to quiz selection. Pick a quiz and then just hit the start button! At the end, all your points will be tallied up. 