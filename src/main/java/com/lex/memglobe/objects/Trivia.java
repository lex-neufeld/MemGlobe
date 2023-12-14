package com.lex.memglobe.objects;

import java.util.ArrayList;

public class Trivia {
    private String id; //unique name
    Display display = new Display(); //primary information to be presented: text, audio, map, picture, etc.
    Object location; //various latitude and longitude values
    String category; //each trivia belongs to exactly one widely accepted category of Geography Trivia such as Country, Capital, River. It probably needs to be repeated in the id such as France_Country, France_Capital, Sein_River
    ArrayList<String> groups; //For establishing group rules. For internal logic, this is actually redundant with category, but makes the structure easier to understand. Examples of groups that could be used to filter trivia in or out include regions (Africa, EU), alliances (NATO, CSTO), landlocked, on the Danube.
    boolean askable; //can this trivia be used as a question to other trivia?
    ArrayList<Trivia> answers = new ArrayList<>(); //all the other Trivia that can be answers to this trivia
    ArrayList<Trivia> old; //previous versions of this Trivia so you know you aren't going crazy when things change

    public Trivia(String id, String category, boolean askable) {
        this.id = id;
        this.category = category;
        this.askable = askable;
    }

    public String getCategory() {
        return category;
    }
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
        answers.add(answer);
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
