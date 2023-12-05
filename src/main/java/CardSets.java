import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CardSets {
    static void importList(String file, ArrayList<Globe.Trivia> scopedSet) {
        try{
            Scanner myScanner = new Scanner(new File(file));

            //How wide is the list and what are the category names for each column?
            String column0 = "country";
            String column1 = "capital";
            System.out.println(scopedSet);


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

                //set the answers for each field to the other fields
                ArrayList<String> currentColumn0Answers = new ArrayList<>(Arrays.asList(currentColumn1Id));
                ArrayList<String> currentColumn1Answers = new ArrayList<>(Arrays.asList(currentColumn0Id));

                //create a new Trivia in currentSet for each field
                scopedSet.add(new Globe.Trivia(currentColumn0Id, column0, true, currentColumn0Answers));
                scopedSet.add(new Globe.Trivia(currentColumn1Id, column1, true, currentColumn1Answers));


            }
            myScanner.close();
            file += "altered";
            System.out.println(file);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
