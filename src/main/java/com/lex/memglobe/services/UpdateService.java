package com.lex.memglobe.services;

import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;

import java.util.ArrayList;

public class UpdateService {
    public static void mergeTrivia (CardSet set1, CardSet set2){
        for (Trivia trivia : set1.getDeck()){
            String node = trivia.getNode();
            ArrayList<String> nodeCategories = new ArrayList<>();
            //initNode in target set if not already present
            if (!set2.getNodes().containsKey(node)){
                set2.initNode(node);
            }
            //generate list of the categories of the Trivia in node
            for (Trivia t : set2.getNodes().get(node)){
                nodeCategories.add(t.getCategory());
            }
            //add trivia to Deck and Node if not already present in node
            if (!nodeCategories.contains(trivia.getCategory())){
                set2.addTrivia(trivia);
                set2.addToNode(node, trivia);

            }
            //update .answers in node
            //TODO support trivia that are in multiple nodes
            //TODO set answers selectively. ie Euro€ is an answer to Paris, but Paris is not an answer to Euro€
            for (Trivia t : set2.getNodes().get(node)){
                for (Trivia i : set2.getNodes().get(node)){
                    t.addAnswer(i);
                }
            }
        }
    }
}
