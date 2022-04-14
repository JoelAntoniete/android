package com.example.offlinequiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionList> matematicaQuestions(){

        final List<QuestionList> questionsLists = new ArrayList<> ();

        final QuestionList question1 = new QuestionList ("o que é uma funcao", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question2 = new QuestionList ("questao numero 2", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question3 = new QuestionList ("questao numero 3", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question4 = new QuestionList ("questao numero 4", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question5 = new QuestionList ("questao numero 5", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question6 = new QuestionList ("questao numero 6", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");

        questionsLists.add (question1);
        questionsLists.add (question2);
        questionsLists.add (question3);
        questionsLists.add (question4);
        questionsLists.add (question5);
        questionsLists.add (question6);

        return questionsLists;
    }
    private static List<QuestionList> geografiaQuestions(){

        final List<QuestionList> questionsLists = new ArrayList<> ();

        final QuestionList question1 = new QuestionList ("questao numero 1", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question2 = new QuestionList ("questao numero 2", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question3 = new QuestionList ("questao numero 3", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question4 = new QuestionList ("questao numero 4", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question5 = new QuestionList ("questao numero 5", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question6 = new QuestionList ("questao numero 6", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");


        questionsLists.add (question1);
        questionsLists.add (question2);
        questionsLists.add (question3);
        questionsLists.add (question4);
        questionsLists.add (question5);
        questionsLists.add (question6);

        return questionsLists;
    }
    private static List<QuestionList> portuguesQuestions(){

        final List<QuestionList> questionsLists = new ArrayList<> ();

        final QuestionList question1 = new QuestionList ("questao numero 1", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question2 = new QuestionList ("questao numero 2", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question3 = new QuestionList ("questao numero 3", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question4 = new QuestionList ("questao numero 4", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question5 = new QuestionList ("questao numero 5", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question6 = new QuestionList ("questao numero 6", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");

        questionsLists.add (question1);
        questionsLists.add (question2);
        questionsLists.add (question3);
        questionsLists.add (question4);
        questionsLists.add (question5);
        questionsLists.add (question6);

        return questionsLists;
    }
    private static List<QuestionList> cienciasQuestions(){

        final List<QuestionList> questionsLists = new ArrayList<> ();

        final QuestionList question1 = new QuestionList ("questao numero 1", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question2 = new QuestionList ("questao numero 2", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question3 = new QuestionList ("questao numero 3", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question4 = new QuestionList ("questao numero 4", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question5 = new QuestionList ("questao numero 5", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");
        final QuestionList question6 = new QuestionList ("questao numero 6", "resposta A", "resposta B", "resposta C", "Resposta D", "resposta A", "");

        questionsLists.add (question1);
        questionsLists.add (question2);
        questionsLists.add (question3);
        questionsLists.add (question4);
        questionsLists.add (question5);
        questionsLists.add (question6);

        return questionsLists;
    }
    public static List<QuestionList> getQuestions(String selectedTopicName){

        switch (selectedTopicName){

            case "matematica":
                return matematicaQuestions ();
            case "geografia":
                return geografiaQuestions ();
            case "portugues":
                return portuguesQuestions ();
            default:
                return cienciasQuestions ();
        }


    }


}
