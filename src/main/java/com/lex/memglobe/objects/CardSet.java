package com.lex.memglobe.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class CardSet {
    String name;
    ArrayList<Trivia> deck = new ArrayList<>();
    HashMap<String, ArrayList<Trivia>> nodes = new HashMap<>();
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

    public HashMap<String, ArrayList<Trivia>> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, ArrayList<Trivia>> nodes) {
        this.nodes = nodes;
    }

    public void initNode(String node) {
        if (this.nodes.containsKey(node)){
            //If the node is already present, something has probably gone wrong. Generate and error and do not add a duplicate.
            System.out.println("Node already exists.");
        }else{
            this.nodes.put(node, new ArrayList<Trivia>());
        }
    }
    public void addToNode(String node, Trivia trivia){
        nodes.get(node).add(trivia);
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
