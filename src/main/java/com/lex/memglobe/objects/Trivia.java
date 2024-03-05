package com.lex.memglobe.objects;

import java.util.ArrayList;
import java.util.Date;

public class Trivia {
    String triviaName; //unique name to make maintenance easier. snake case of the question with category ex: france_Country, france_Map, france_Flag, french_Greeting, paris_Capital
    String question; //this text is what the user sees. Can be html link to media.
    ArrayList<Trivia> answers = new ArrayList<>(); //all the other Trivia that can be answers to this Trivia
    String note;
    String category; //each trivia belongs to exactly one widely accepted category of Geography Trivia such as Country, Capital, River, Flag. It needs to be repeated in the triviaName such as france_country, france_flag
    ArrayList <String> clusters = new ArrayList<>(); //each trivia can belong to 0 or more clusters. Further information about clusters is in CardSet.clusters
    ArrayList<String> groups = new ArrayList<>(); //For establishing group rules. For internal logic, this is actually redundant with category, but makes the structure easier to understand. Examples of groups that could be used to filter trivia in or out include regions (Africa, EU), alliances (NATO, CSTO), landlocked, on the Danube.
    Object location; //various latitude and longitude values
    boolean askable; //can this trivia be used as a question to other trivia?
    String source;
    Date sourceDate;

    ArrayList<Trivia> old; //previous versions of this Trivia so you know you aren't going crazy when things change

    public Trivia(String triviaName, String category, String cluster, boolean askable, String source, Date date) {
        this.triviaName = triviaName;
        this.category = category;
        this.clusters.add(cluster);
        this.askable = askable;
        this.source = source;
        this.sourceDate = date;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }
    public ArrayList<String> getClusters() {
        return clusters;
    }
    public String getSource() {return source;}
    public Date getSourceDate() {return sourceDate;}
    public ArrayList<Trivia> getAnswers() {
        return answers;
    }
    public String displayAnswers(){
        String text = "Answers:\n";
        for (Trivia answer : answers){
            text += answer.getCategory() + ": " + answer.getQuestion() + "\n";
        }
        return text;
    }

    public void setAnswers(ArrayList<Trivia> answers) {
        this.answers = answers;
    }
    public void addAnswer(Trivia answer) {
        //discard attempts to add a trivia as an answer to itself or to add duplicate answers
        if (this != answer && !answers.contains(answer)){
            answers.add(answer);
        }
    }

    public String getTriviaName() {
        return triviaName;
    }
}
