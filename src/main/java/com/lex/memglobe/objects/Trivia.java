package com.lex.memglobe.objects;

import java.util.ArrayList;
import java.util.Date;

public class Trivia {
    String triviaName; //unique name to make maintenance easier. snake case of the question with category ex: france_Country, france_Map, france_Flag, french_Greeting, paris_Capital
    String answer; //this text is what the user sees. Can be html link to media.
    ArrayList<Trivia> questions = new ArrayList<>(); //all the other Trivia that can be questions to this Trivia
    String note; //for any additional information that doesn't fit the standard
    String category; //each trivia belongs to exactly one widely accepted category of Geography Trivia such as Country, Capital, River, Flag. It needs to be repeated in the triviaName such as france_country, france_flag
    ArrayList <String> clusters = new ArrayList<>(); //each trivia can belong to 0 or more clusters. Further information about clusters is in CardSet.clusters
    ArrayList<String> groups = new ArrayList<>(); //For establishing group rules. For internal logic, this is actually redundant with category, but makes the structure easier to understand. Examples of groups that could be used to filter trivia in or out include regions (Africa, EU), alliances (NATO, CSTO), landlocked, on the Danube.
    Object location; //TODO vektor object for lat. and long.
    boolean askable; //can this trivia be used as a question to other trivia?
    String source;
    Date sourceDate;

    public Trivia(String triviaName, String category, String cluster, boolean askable, String source, Date date) {
        this.triviaName = triviaName;
        this.category = category;
        this.clusters.add(cluster);
        this.askable = askable;
        this.source = source;
        this.sourceDate = date;
    }

    public String getTriviaName() {
        return triviaName;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public ArrayList<Trivia> getQuestions() {
        return questions;
    }
    public String displayQuestions(){
        StringBuilder text = new StringBuilder("Answers:\n");
        for (Trivia question : questions){
            text.append(question.getCategory()).append(": ").append(question.getAnswer()).append("\n");
        }
        return text.toString();
    }
    public void setQuestions(ArrayList<Trivia> questions) {
        this.questions = questions;
    }
    public void addAnswer(Trivia answer) {
        //discard attempts to add a trivia as an answer to itself or to add duplicate answers
        if (this != answer && !questions.contains(answer)){
            questions.add(answer);
        }
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getCategory() {return category;}
    public ArrayList<String> getClusters() {return clusters;}
    public String getSource() {return source;}
    public Date getSourceDate() {return sourceDate;}



}
