package com.tanishqmittal.braintrainerapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.logging.Handler;


public class MainActivity extends AppCompatActivity {
    Button goButton;
    Button option1Button;
    Button option2Button;
    Button option3Button;
    Button option4Button;
    Button playAgainButton;
    TextView timerTextView;
    TextView scoreTextView;
    TextView questionTextView;
    CountDownTimer countDownTimer;
    TextView resultTextView;
    int correctAnswer = -1;
    int numberOfAttempts;
    int numberOfCorrectAnswers;
    String string = "Correct";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        goButton = (Button) findViewById(R.id.goButton);
        option1Button = (Button) findViewById(R.id.option1Button);
        option2Button = (Button) findViewById(R.id.option2Button);
        option3Button = (Button) findViewById(R.id.option3Button);
        option4Button = (Button) findViewById(R.id.option4Button);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);

        timerTextView = (TextView) findViewById(R.id.timerTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        questionTextView = (TextView) findViewById(R.id.questionTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    public void goButtonClicked(View view) {

        numberOfAttempts = 0;
        numberOfCorrectAnswers = 0;

        goButton.setVisibility(View.GONE);
        option1Button.setVisibility(View.VISIBLE);
        option2Button.setVisibility(View.VISIBLE);
        option3Button.setVisibility(View.VISIBLE);
        option4Button.setVisibility(View.VISIBLE);

        timerTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        questionTextView.setVisibility(View.VISIBLE);
        resultTextView.setVisibility(View.VISIBLE);

        //option1Button.setText("45");
        askQuestions();
        //setOptions();
        //option1Button.setText(Integer.toString(numberOfAttempts));
        startTimer();




    }
    public void startTimer() {
        new CountDownTimer(31000, 1000) {


            @Override
            public void onTick(long l) {
                long remainedSeconds = l / 1000;

                timerTextView.setText(Long.toString(remainedSeconds));
            }


            @Override
            public void onFinish() {
                timerTextView.setText("0");
                option1Button.setEnabled(false);
                option2Button.setEnabled(false);
                option3Button.setEnabled(false);
                option4Button.setEnabled(false);
                playAgainButton.setVisibility(View.VISIBLE);
                resultTextView.setText("Final Score is : " + numberOfCorrectAnswers + "/" + numberOfAttempts);


            }
        }.start();
    }

    public void askQuestions() {



        int randomNumber1 = generateRandomNumber(0,20);
        int randomNumber2 = generateRandomNumber(0,20);

        questionTextView.setText(randomNumber1 + "+" + randomNumber2);
        correctAnswer = randomNumber1 + randomNumber2;
        setOptions();
    }

    public void setOptions() {

        int positionOfCorrectAnswer = generateRandomNumber(1,4);

            if(positionOfCorrectAnswer ==1) {
                option1Button.setText(Integer.toString(correctAnswer));
                int wrongNumber1 = generateRandomNumber(0,40);
                option2Button.setText(Integer.toString(wrongNumber1));
                int wrongNumber2 = generateRandomNumber(0,40);
                option3Button.setText(Integer.toString(wrongNumber2));
                int wrongNumber3 = generateRandomNumber(0,40);
                option4Button.setText(Integer.toString(wrongNumber3));
            }
            else if(positionOfCorrectAnswer==2) {

                option2Button.setText(Integer.toString(correctAnswer));
                int wrongNumber1 = generateRandomNumber(0,40);
                option1Button.setText(Integer.toString(wrongNumber1));
                int wrongNumber2 = generateRandomNumber(0,40);
                option3Button.setText(Integer.toString(wrongNumber2));
                int wrongNumber3 = generateRandomNumber(0,40);
                option4Button.setText(Integer.toString(wrongNumber3));
            }
            else if(positionOfCorrectAnswer==3) {

                option3Button.setText(Integer.toString(correctAnswer));
                int wrongNumber1 = generateRandomNumber(0,40);
                option1Button.setText(Integer.toString(wrongNumber1));
                int wrongNumber2 = generateRandomNumber(0,40);
                option2Button.setText(Integer.toString(wrongNumber2));
                int wrongNumber3 = generateRandomNumber(0,40);
                option4Button.setText(Integer.toString(wrongNumber3));
            }
            else if(positionOfCorrectAnswer==4) {

                option4Button.setText(Integer.toString(correctAnswer));
                int wrongNumber1 = generateRandomNumber(0,40);
                option1Button.setText(Integer.toString(wrongNumber1));
                int wrongNumber2 = generateRandomNumber(0,40);
                option2Button.setText(Integer.toString(wrongNumber2));
                int wrongNumber3 = generateRandomNumber(0,40);
                option3Button.setText(Integer.toString(wrongNumber3));

            }



    }

    public void optionClicked(View view) {
        switch (view.getId()) {

            case R.id.option1Button: {
                if(option1Button.getText().equals(Integer.toString(correctAnswer))) {
                    numberOfAttempts++; numberOfCorrectAnswers++;
                    //Toast.makeText(MainActivity.this, "Correct !", Toast.LENGTH_SHORT).show();
                    resultTextView.setText("Correct !");
                    scoreTextView.setText(numberOfCorrectAnswers+ "/" + numberOfAttempts);
                    askQuestions();
                }
                else {
                    numberOfAttempts++;
                    resultTextView.setText("Wrong !");
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();

                }
                break;


            }

            case R.id.option2Button: {
                if( option2Button.getText().equals(Integer.toString(correctAnswer))) {
                    numberOfAttempts++; numberOfCorrectAnswers++;
                    resultTextView.setText("Correct !");
                    //Toast.makeText(MainActivity.this, "Correct !", Toast.LENGTH_SHORT).show();
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();
                }
                else {
                    //resultTextView.setText("Wrong !");
                    numberOfAttempts++;
                    resultTextView.setText("Wrong !");
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();
                }
                break;

            }

            case R.id.option3Button: {
                if(option3Button.getText().equals(Integer.toString(correctAnswer))) {
                    numberOfAttempts++; numberOfCorrectAnswers++;
                    resultTextView.setText("Correct !");
                    //Toast.makeText(MainActivity.this, "Correct !", Toast.LENGTH_SHORT).show();
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();
                }
                else {
                    numberOfAttempts++;
                    resultTextView.setText("Wrong !");
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();
                }
                break;

            }

            case R.id.option4Button: {
                if(option4Button.getText().equals(Integer.toString(correctAnswer))) {
                    numberOfAttempts++; numberOfCorrectAnswers++;
                    resultTextView.setText("Correct !");
                    //Toast.makeText(MainActivity.this, "Correct !", Toast.LENGTH_SHORT).show();
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();
                }
                else {
                    numberOfAttempts++;
                    resultTextView.setText("Wrong !");
                    scoreTextView.setText(Integer.toString(numberOfCorrectAnswers)+ "/" + Integer.toString(numberOfAttempts));
                    askQuestions();
                }
                break;

            }

        }



    }


    public void playAgain(View view) {
        option1Button.setEnabled(true);
        option2Button.setEnabled(true);
        option3Button.setEnabled(true);
        option4Button.setEnabled(true);
        playAgainButton.setVisibility(View.INVISIBLE);
        correctAnswer = -1;
        numberOfAttempts = 0;
        numberOfCorrectAnswers = 0;
        scoreTextView.setText("0/0");
        askQuestions();
       startTimer();
    }



    public int generateRandomNumber (int min, int max) {
        int number = min + (int)(Math.random() * ((max - min) + 1));
        if(number==correctAnswer)
        return number+1;
        else
            return number;

    }


 }


