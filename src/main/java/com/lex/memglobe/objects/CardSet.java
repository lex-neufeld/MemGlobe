package com.lex.memglobe.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class CardSet {
    String name;
    ArrayList<Trivia> deck = new ArrayList<>(); //each CardSet should contain exactly one deck of Trivia
    ArrayList<String> categories = new ArrayList<>(); //list of categories in this CardSet
    HashMap<String, ArrayList<Trivia>> clusters = new HashMap<>(); //map of the members of clusters to support quick iteration
    ArrayList<String> groups; //list of groups present in this CardSet

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

    public void addTrivia(Trivia trivia){
        deck.add(trivia);
        //TODO add some checks for clusterExists, categoryExists, !duplicateTrivia
    }
    public ArrayList<String> getCategories() {
        return categories;
    }
    public void addCategory(String category){
        if (this.categories.contains(category)){
            //If the category is already present, something has probably gone wrong. Generate error and don't create a duplicate.
            System.out.println("Category already exists.");
        }else{
            this.categories.add(category);
        }
    }
    public HashMap<String, ArrayList<Trivia>> getClusters() {return clusters;}

    public void initCluster(String cluster) {
        if (this.clusters.containsKey(cluster)){
            //If the cluster is already present, something has probably gone wrong. Generate error and don't create a duplicate.
            System.out.println("Cluster already exists.");
        }else{
            this.clusters.put(cluster, new ArrayList<Trivia>());
        }
    }
    public void addToCluster(String cluster, Trivia trivia){
        clusters.get(cluster).add(trivia);
    }

}
