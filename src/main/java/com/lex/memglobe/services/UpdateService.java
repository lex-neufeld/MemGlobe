package com.lex.memglobe.services;

import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;

import java.util.ArrayList;

public class UpdateService {
    public static void mergeTrivia (CardSet set1, CardSet set2){
        for (Trivia trivia : set1.getDeck()){
            for (String cluster : trivia.getClusters()){
                //initNode in target set if not already present
                if (!set2.getClusters().containsKey(cluster)){
                    set2.initCluster(cluster);
                }
                //generate list of the categories of the Trivia in node
                ArrayList<String> nodeCategories = new ArrayList<>();
                for (Trivia t : set2.getClusters().get(cluster)){
                    nodeCategories.add(t.getCategory());
                }
                //add trivia to Deck and Node if not already present in node
                if (!nodeCategories.contains(trivia.getCategory())){
                    set2.addTrivia(trivia);
                    set2.addToCluster(cluster, trivia);
                }
                //update .answers in node
                //TODO support trivia that are in multiple nodes
                //TODO set answers selectively. ie Euro€ is an answer to Paris, but Paris is not an answer to Euro€
                for (Trivia t : set2.getClusters().get(cluster)){
                    for (Trivia i : set2.getClusters().get(cluster)){
                        t.addAnswer(i);
                    }
                }
            }
        }
    }
}
