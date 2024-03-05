package com.lex.memglobe.services;

import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ImportService {
    public static void importAdda247(String file, CardSet currentSet){
        try {
            Scanner myScanner = new Scanner(new File(file));
            ArrayList<String> keys = new ArrayList<>();
            String node;
            String source = "";
            Date sourceDate = new Date(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while(myScanner.hasNext()){
                //get next line of file, split on tab, .trim() each split, plus lots of magic to get it to return String[]
                String[] currentLine = Arrays.stream(myScanner.nextLine().split("\t")).map(String::trim).toArray(String[]::new);
                //Check for  #Source, store it, display it, continue to next line
                if (currentLine[0].startsWith("#Source")){
                    source = currentLine[1];
                    System.out.println("Source: " + source);
                    continue;
                }
                //Check for #Date, store it, display it, continue to next line
                if (currentLine[0].startsWith("#Date")){
                    sourceDate = sdf.parse(currentLine[1]);
                    System.out.println("Source Date: " + sourceDate);
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

                //TODO ensure that source and sourceDate have been set before continuing

                Trivia currentTrivia;
                //get node name for the current line (ie, the Country)
                node = currentLine[0];
                //add it to CardSet.nodes
                currentSet.initNode(node);

                //for each item in currentLine
                for (int i = 0; i < currentLine.length; i++){
                    //create a Trivia
                    currentTrivia = new Trivia(currentLine[i]+"_"+keys.get(i), keys.get(i),node, true, source, sourceDate);
                    //add Trivia to currentSet
                    currentSet.addTrivia(currentTrivia);
                    //set the Display
                    currentTrivia.setQuestion(currentLine[i]);
                    //add Trivia to its node
                    currentSet.addToNode(node, currentTrivia);
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
}
