package com.lex.memglobe.services;

import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ImportService {
    public static void importAdda247(String file, CardSet currentSet){
        try {
            Scanner myScanner = new Scanner(new File(file));
            ArrayList<String> keys = new ArrayList<>();

            String node;

            while(myScanner.hasNext()){
                //get next line of file, split on tab, .trim() each split, plus lots of magic to get it to return String[]
                String[] currentLine = Arrays.stream(myScanner.nextLine().split("\t")).map(String::trim).toArray(String[]::new);
                //Check for  #Source and display it
                if (currentLine[0].startsWith("#Source")){
                    System.out.println("Source: " + Arrays.toString(currentLine));
                    continue;
                }
                //Check for #Key and create list of keys in lowercase
                if (currentLine[0].startsWith("#Key")){
                    currentLine = String.join(",", currentLine).toLowerCase().split(",");
                    keys.addAll(Arrays.asList(currentLine).subList(1, currentLine.length)); //sublist(1, because the first item is "#Key"
                    System.out.println("Keys: " + keys);
                    //adds all keys as categories
                    //TODO change this to logic for selecting which keys to add
                    for (String key : keys){
                        currentSet.addCategory(key);
                    }
                    continue;
                }
                //print any other lines that have been commented out with # and skip them
                if (currentLine[0].startsWith("#")){
                    System.out.println("Commented Line: " + Arrays.toString(currentLine));
                    continue;
                }
                //do a sanity check on the line before trying to create id for each key
                //TODO Carina says I should do exception handling here...
                if (!(keys.size() == currentLine.length)){
                    System.out.println("Number of keys and number of fields doesn't match at this line. ABORTING");
                    System.out.println(keys);
                    System.out.println(Arrays.toString(currentLine));
                    break;
                }

                //make a node for the current line (ie, the Country)
                node = currentLine[0];
                currentSet.addNode(node);
                //for each item in currentLine
                for (int i = 0; i < currentLine.length; i++){
                    //create a new Trivia in currentSet
                    currentSet.addTrivia(new Trivia(currentLine[i]+"_"+keys.get(i), keys.get(i),true, node));
                    //set the Display for each Trivia
                    currentSet.getDeck().get(currentSet.getDeck().size()-1).getDisplay().setText(currentLine[i]);
                }
                //set the answers for each Trivia to the other items from currentLine
                //TODO set .answers for Trivia IFF they are flagged askable
                //TODO detect if a Trivia.display is a duplicate (ex: Euro€, Jerusalem), use that one instead of creating a new one, and figure out what to do with Trivia.node
                for (int i = 0; i < currentLine.length; i++){
                    for (int o = 0; o < currentLine.length; o++) {
                        if (!(i == o)) {
                            currentSet.getDeck().get(currentSet.getDeck().size() - i - 1).addAnswer(currentSet.getDeck().get(currentSet.getDeck().size() - o - 1));
                        }
                    }
                }
            }
            myScanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void importWordmeters(String file, ArrayList<Trivia> currentSet) {
        try{
            Scanner myScanner = new Scanner(new File(file));
            ArrayList<String> keys = new ArrayList<>();

            //TODO each node can represent a group of trivia that all point at eachother, such as a country, to facilitate maintaining groups of Trivia
            //int currentNode = 0;
            //ArrayList<String> nodes = new ArrayList<>();

            while(myScanner.hasNext()){
                //get next line of file split on tab
                String[] currentLine = myScanner.nextLine().split("\t");
                //Check for  #Source
                if (currentLine[0].startsWith("#Source")){
                    System.out.println(Arrays.toString(currentLine));
                    continue;
                }
                //Check for #Key
                if (currentLine[0].startsWith("#Key")){
                    keys.addAll(Arrays.asList(currentLine).subList(1, currentLine.length));
                    continue;
                }
                //print any other lines that have been commented out with # and skip them
                if (currentLine[0].startsWith("#")){
                    System.out.println(Arrays.toString(currentLine));
                    continue;
                }
                //do a sanity check on the line before trying to create id for each key
                if (!(keys.size() == currentLine.length)){
                    System.out.println("Number of keys and number of fields doesn't match at this line. ABORTING");
                    System.out.println(keys);
                    System.out.println(Arrays.toString(currentLine));
                    break;
                }
                //TODO fix this crap where we start at i=1 and then later .get(i-1) to skip past the index column of the source file
                String node;
                for (int i = 1; i < currentLine.length; i++){
                    node = currentLine[1];
                    //at same time, create a new Trivia in currentSet for each field
                    currentSet.add(new Trivia(currentLine[i]+"_"+keys.get(i), keys.get(i),true, node));
                    //set the Display for each Trivia
                    currentSet.get(currentSet.size()-1).getDisplay().setText(currentLine[i]);
                }
                //set the answers for each Trivia to the other items
                for (int i = 1; i < currentLine.length; i++){
                    for (int o = 1; o < currentLine.length; o++) {
                        if (i != o) {
                            currentSet.get(currentSet.size() - i).addAnswer(currentSet.get(currentSet.size() - o));
                        }
                    }
                }
            }
            myScanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
