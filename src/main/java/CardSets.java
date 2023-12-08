import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CardSets {
    static void importList(String file, ArrayList<Globe.Trivia> currentSet) {
        try{
            Scanner myScanner = new Scanner(new File(file));
            //TODO each node can represent a group of trivia that all point at eachother
            int node = 0;

            //How wide is the list and what are the category names for each column?
            String column0 = "country";
            String column1 = "capital";


            while(myScanner.hasNext()){
                //get next line of file split on tab
                String[] currentLine = myScanner.nextLine().split("\t");
                //skip lines that have been commented out with #
                if (currentLine[0].startsWith("#")){
                    System.out.println(currentLine[0]);
                    continue;
                }
                //create Trivia.id for each field by adding the contents of the field to "_category"
                String currentColumn0Id = currentLine[0]+"_"+column0;
                String currentColumn1Id = currentLine[1]+"_"+column1;

                //create a new Trivia in currentSet for each field
                currentSet.add(new Globe.Trivia(currentColumn0Id, column0, true));
                currentSet.add(new Globe.Trivia(currentColumn1Id, column1, true));

                //set the Display for each Trivia
                currentSet.get(currentSet.size()-2).display.setText(currentLine[0]);
                currentSet.get(currentSet.size()-1).display.setText(currentLine[1]);

                //set the answers for each field to the other fields
                currentSet.get(currentSet.size()-2).addAnswer(currentSet.get(currentSet.size()-1));
                currentSet.get(currentSet.size()-1).addAnswer(currentSet.get(currentSet.size()-2));

            }
            myScanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
