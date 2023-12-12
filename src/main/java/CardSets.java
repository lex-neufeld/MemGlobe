import com.lex.memglobe.objects.Trivia;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CardSets {
    static void importAdda247(String file, ArrayList<Trivia> currentSet){
        try {
            Scanner myScanner = new Scanner(new File(file));
            ArrayList<String> keys = new ArrayList<>();

            //TODO each node can represent a group of trivia that all point at eachother, such as a country, to facilitate maintaining/extending groups of Trivia
            //int currentNode = 0;
            //ArrayList<String> nodes = new ArrayList<>();

            while(myScanner.hasNext()){
                //get next line of file split on tab and .trim() plus lots of magic to get it to return String[]
                String[] currentLine = Arrays.stream(myScanner.nextLine().split("\t")).map(String::trim).toArray(String[]::new);
                //Check for  #Source
                if (currentLine[0].startsWith("#Source")){
                    System.out.println("Source: " + Arrays.toString(currentLine));
                    continue;
                }
                //Check for #Key
                if (currentLine[0].startsWith("#Key")){
                    //TODO make them all lowercase
                    keys.addAll(Arrays.asList(currentLine).subList(1, currentLine.length)); //sublist(1, because the first item is "#Key"
                    System.out.println("Keys: " + keys);
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

                for (int i = 0; i < currentLine.length; i++){
                    //create a new Trivia in currentSet for each item in currentLine
                    currentSet.add(new Trivia(currentLine[i]+"_"+keys.get(i), keys.get(i),true));
                    //set the Display for each Trivia
                    currentSet.get(currentSet.size()-1).getDisplay().setText(currentLine[i]);
                }
                //set the answers for each Trivia to the other items from currentLine
                //TODO set .answers for Trivia IFF they are flagged askable
                //TODO detect if a Trivia is a duplicate (ex: Euro€, Jerusalem) and use that one instead of creating a new one
                for (int i = 0; i < currentLine.length; i++){
                    for (int o = 0; o < currentLine.length; o++) {
                        if (!(i == o)) {
                            currentSet.get(currentSet.size() - i - 1).addAnswer(currentSet.get(currentSet.size() - o - 1));
                        }
                    }
                }
            }
            myScanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void importList(String file, ArrayList<Trivia> currentSet) {
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
                for (int i = 1; i < currentLine.length; i++){
                    //at same time, create a new Trivia in currentSet for each field
                    currentSet.add(new Trivia(currentLine[i]+"_"+keys.get(i), keys.get(i),true));
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
