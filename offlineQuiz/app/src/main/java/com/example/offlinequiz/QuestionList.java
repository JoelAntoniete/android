package com.example.offlinequiz;

public class QuestionList {
    private String question, option1, option2, option3, option4, answer;
    private String userSelectedAnswer;

    public QuestionList(String question, String question1, String question2, String question3, String question4, String answer, String userSelectedAnswer) {
        this.question = question;
        this.option1 = question1;
        this.option2 = question2;
        this.option3 = question3;
        this.option4 = question4;
        this.answer = answer;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestion1() {
        return option1;
    }

    public String getQuestion2() {
        return option2;
    }

    public String getQuestion3() {
        return option3;
    }

    public String getQuestion4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}
