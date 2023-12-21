package com.lex.memglobe.objects;

import java.util.ArrayList;
import java.util.Date;

public class Trivia {
    String id; //unique name
    Display display = new Display(); //primary information to be presented: text, audio, map, picture, etc.
    String category; //each trivia belongs to exactly one widely accepted category of Geography Trivia such as Country, Capital, River. It probably needs to be repeated in the id such as France_Country, France_Capital, Sein_River
    String node;
    ArrayList<String> groups; //For establishing group rules. For internal logic, this is actually redundant with category, but makes the structure easier to understand. Examples of groups that could be used to filter trivia in or out include regions (Africa, EU), alliances (NATO, CSTO), landlocked, on the Danube.
    Object location; //various latitude and longitude values
    boolean askable; //can this trivia be used as a question to other trivia?
    String source;
    Date sourceDate;
    ArrayList<Trivia> answers = new ArrayList<>(); //all the other Trivia that can be answers to this trivia
    ArrayList<Trivia> old; //previous versions of this Trivia so you know you aren't going crazy when things change

    public Trivia(String id, String category, String node, boolean askable, String source, Date date) {
        this.id = id;
        this.category = category;
        this.node = node;
        this.askable = askable;
        this.source = source;
        this.sourceDate = date;
    }


    public String getCategory() {
        return category;
    }
    public String getNode() {
        return node;
    }
    public String getSource() {return source;}
    public Date getSourceDate() {return sourceDate;}
    public ArrayList<Trivia> getAnswers() {
        return answers;
    }
    public void displayAnswers(){
        for (Trivia answer : answers){
            System.out.print(answer.getCategory() + ": ");
            answer.display.display();
        }
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

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public String getId() {
        return id;
    }
}
