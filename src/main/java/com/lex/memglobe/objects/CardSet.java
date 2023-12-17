package com.lex.memglobe.objects;

import java.util.ArrayList;

public class CardSet {
    String name;
    ArrayList<Trivia> deck = new ArrayList<>();
    ArrayList<String> nodes = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();

    public CardSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Trivia> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Trivia> deck) {
        this.deck = deck;
    }

    public void addTrivia(Trivia trivia){
        deck.add(trivia);
        //TODO add some checks for nodeExists, categoryExists, !duplicateTrivia
    }

    public ArrayList<String> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<String> nodes) {
        this.nodes = nodes;
    }

    public void addNode(String node) {
        if (this.nodes.contains(node)){
            //If the node is already present, something has probably gone wrong.
            System.out.println("Node already exists.");
        }else{
            this.nodes.add(node);
        }
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void addCategory(String category){
        if (this.categories.contains(category)){
            //If the category is already present, something has probably gone wrong.
            System.out.println("Category already exists.");
        }else{
            this.categories.add(category);
        }
    }
}
