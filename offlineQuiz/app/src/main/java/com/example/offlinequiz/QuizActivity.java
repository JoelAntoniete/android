package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {
    private TextView questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int totalTimeInMins = 1;
    private int seconds = 0;

    private List<QuestionList> questionLists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_quiz);

        final ImageView backbtn = findViewById (R.id.back_btn);
        final TextView timer = findViewById (R.id.timer);
        final TextView selectedTopicName = findViewById (R.id.topicName);

        questions = findViewById (R.id.questions);
        question = findViewById (R.id.question);

        option1 =  findViewById (R.id.option1);
        option2 =  findViewById (R.id.option2);
        option3 =  findViewById (R.id.option3);
        option4 =  findViewById (R.id.option4);

        nextBtn = findViewById (R.id.nexBtn);
        final String getSelectedTopicName = getIntent ().getStringExtra ("selectedTopic");

        selectedTopicName.setText (getSelectedTopicName);

        questionLists = QuestionsBank.getQuestions (getSelectedTopicName);

        startTimer (timer);

        questions.setText ((currentQuestionPosition+1)+ "/" + questionLists.size());
        question.setText (questionLists.get(0).getQuestion ());
        option1.setText (questionLists.get(0).getQuestion1 ());
        option2.setText (questionLists.get(0).getQuestion2 ());
        option3.setText (questionLists.get(0).getQuestion3 ());
        option4.setText (questionLists.get(0).getQuestion4 ());

        option1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty ()){
                    selectedOptionByUser = option1.getText ().toString ();

                    option1.setBackgroundResource (R.drawable.round_back_red10);
                    option1.setTextColor (Color.WHITE);
                    revealAnswer ();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer (selectedOptionByUser);
                }

            }
        });

        option2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty ()){
                    selectedOptionByUser = option2.getText ().toString ();

                    option2.setBackgroundResource (R.drawable.round_back_red10);
                    option2.setTextColor (Color.WHITE);
                    revealAnswer ();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer (selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty ()){
                    selectedOptionByUser = option3.getText ().toString ();

                    option3.setBackgroundResource (R.drawable.round_back_red10);
                    option3.setTextColor (Color.WHITE);
                    revealAnswer ();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer (selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty ()){
                    selectedOptionByUser = option4.getText ().toString ();

                    option4.setBackgroundResource (R.drawable.round_back_red10);
                    option4.setTextColor (Color.WHITE);
                    revealAnswer ();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer (selectedOptionByUser);
                }
            }
        });

        nextBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty ()){
                    Toast.makeText (QuizActivity.this, "Por Favor selecione uma opção", Toast.LENGTH_SHORT).show ();
                }
                else{

                }
            }
        });

        backbtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                quizTimer.purge ();
                quizTimer.cancel ();

                startActivity (new Intent (QuizActivity.this, MainActivity.class) );
                finish ();
            }
        });


    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionLists.size ()){
            nextBtn.setText ("quiz feito");
        }
        if(currentQuestionPosition < questionLists.size ()){
            selectedOptionByUser = "";

            option1.setBackgroundResource (R.drawable.round_back_white_stroler2_10);
            option1.setTextColor (Color.parseColor ("#1F6BB8"));

            option2.setBackgroundResource (R.drawable.round_back_white_stroler2_10);
            option2.setTextColor (Color.parseColor ("#1F6BB8"));

            option3.setBackgroundResource (R.drawable.round_back_white_stroler2_10);
            option3.setTextColor (Color.parseColor ("#1F6BB8"));

            option4.setBackgroundResource (R.drawable.round_back_white_stroler2_10);
            option4.setTextColor (Color.parseColor ("#1F6BB8"));

            questions.setText ((currentQuestionPosition+1)+ "/" + questionLists.size());
            question.setText (questionLists.get(currentQuestionPosition).getQuestion ());
            option1.setText (questionLists.get(currentQuestionPosition).getQuestion1 ());
            option2.setText (questionLists.get(currentQuestionPosition).getQuestion2 ());
            option3.setText (questionLists.get(currentQuestionPosition).getQuestion3 ());
            option4.setText (questionLists.get(currentQuestionPosition).getQuestion4 ());
        }
        else{
            Intent intent = new Intent (QuizActivity.this, QuizResults.class);
            intent.putExtra ("correto", getCorrectAnswers ());
            intent.putExtra ("incorreto", getInCorrectAnswers ());
            startActivity (intent);

            finish (); //50:15###########################################################get
        }
    }
    private void startTimer(TextView timerTextView){
        quizTimer = new Timer ();

        quizTimer.scheduleAtFixedRate (new TimerTask () {
            @Override
            public void run() {
                if (seconds == 0){
                    totalTimeInMins--;
                    seconds = 59;
                }else if (seconds == 0 && totalTimeInMins == 0){
                    quizTimer.purge ();
                    quizTimer.cancel ();

                    Toast.makeText (QuizActivity.this, "Fim do Tempo", Toast.LENGTH_SHORT).show ();

                    Intent intent = new Intent (QuizActivity.this, QuizResults.class);
                    intent.putExtra ("corretos: ", getCorrectAnswers ());
                    intent.putExtra ("Incorreto:", getInCorrectAnswers () );
                    startActivity (intent);

                    finish ();

                }
                else{
                    seconds--;
                }
                runOnUiThread (new Runnable () {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf (totalTimeInMins);
                        String finalSeconds = String.valueOf (seconds);

                        if(finalMinutes.length () == 1){
                            finalMinutes = "0"+finalMinutes;
                        }
                        if (finalSeconds.length () == 1){
                            finalSeconds = "0"+finalSeconds;
                        }

                        timerTextView.setText (finalMinutes + ":" + finalSeconds);

                    }
                });

            }
        },1000, 1000);
    }
    private int getCorrectAnswers(){
        int correctAnswers = 0;

        for (int i=0; i<questionLists.size();i++){
            final String getUserSelectedAnswer = questionLists.get (i).getUserSelectedAnswer ();
            final String getAnswer = questionLists.get (i).getAnswer ();

            if(getUserSelectedAnswer.equals (getAnswer)){
                correctAnswers++;
            }

        }
        return correctAnswers;
    }
    private int getInCorrectAnswers(){
        int correctAnswers = 0;

        for (int i=0; i<questionLists.size();i++){
            final String getUserSelectedAnswer = questionLists.get (i).getUserSelectedAnswer ();
            final String getAnswer = questionLists.get (i).getAnswer ();

            if(!getUserSelectedAnswer.equals (getAnswer)){
                correctAnswers++;
            }

        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge ();
        quizTimer.cancel ();

        startActivity (new Intent (QuizActivity.this, MainActivity.class) );
        finish ();

    }

    private void revealAnswer(){

        final String getAnswer =  questionLists.get (currentQuestionPosition).getAnswer ();

        if (option1.getText ().toString ().equals (getAnswer)){
            option1.setBackgroundResource (R.drawable.round_back_green10);
            option1.setTextColor (Color.WHITE);
        }
        else if(option2.getText ().toString ().equals (getAnswer)){

            option2.setBackgroundResource (R.drawable.round_back_green10);
            option2.setTextColor (Color.WHITE);
        }
        else if(option3.getText ().toString ().equals (getAnswer)) {

            option3.setBackgroundResource (R.drawable.round_back_green10);
            option3.setTextColor (Color.WHITE);
        }
        else if(option4.getText ().toString ().equals (getAnswer)) {

            option4.setBackgroundResource (R.drawable.round_back_green10);
            option4.setTextColor (Color.WHITE);
        }

    }
}