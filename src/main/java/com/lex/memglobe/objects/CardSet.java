package com.lex.memglobe.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class CardSet {
    String name;
    ArrayList<Trivia> deck = new ArrayList<>();
    HashMap<String, ArrayList<Trivia>> clusters = new HashMap<>();
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
        //TODO add some checks for clusterExists, categoryExists, !duplicateTrivia
    }

    public HashMap<String, ArrayList<Trivia>> getClusters() {
        return clusters;
    }

    public void setClusters(HashMap<String, ArrayList<Trivia>> clusters) {
        this.clusters = clusters;
    }

    public void initCluster(String cluster) {
        if (this.clusters.containsKey(cluster)){
            //If the cluster is already present, something has probably gone wrong. Generate and error and do not add a duplicate.
            System.out.println("Cluster already exists.");
        }else{
            this.clusters.put(cluster, new ArrayList<>());
        }
    }
    public void addToCluster(String cluster, Trivia trivia){
        clusters.get(cluster).add(trivia);
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void addCategory(String category){
        if (this.categories.contains(category)){
            //If the category is already present, something has probably gone wrong. Generate error message and don't create a duplicate.
            System.out.println("Category already exists.");
        }else{
            this.categories.add(category);
        }
    }
}
