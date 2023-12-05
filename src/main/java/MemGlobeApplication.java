import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MemGlobeApplication {
    public static class Trivia{
        String id; //unique name
        Object information; //primary information to be presented: text, audio, map, picture, etc.
        Object location; //various latitude and longitude values
        String category; //each trivia belongs to exactly one widely accepted category of Geography Trivia such as Country, Capital, River. It probably needs to be repeated in the id such as France_Country, France_Capital, Sein_River
        ArrayList<String> groups; //For establishing group rules. For internal logic, this is actually redundant with category, but makes the structure easier to understand. Examples of groups that could be used to filter trivia in or out include regions (Africa, EU), alliances (NATO, CSTO), landlocked, on the Danube.
        boolean askable; //can this trivia be used as a question to other trivia?

        public void addAnswer(String answer) {
            this.answers.add(answer);
        }

        ArrayList<String> answers; //all the other Trivia.id that can be answers to this trivia
        ArrayList<Trivia> old; //previous versions of this Trivia so you know you aren't going crazy when things change

        public Trivia(String id, String category, boolean askable, ArrayList<String> answers) {
            this.id = id;
            this.category = category;
            this.askable = askable;
            this.answers = answers;
        }
    }


    public static void main(String[] args) {
        ArrayList<Trivia> currentSet = new ArrayList<>();
        try{
            Scanner myScanner = new Scanner(new File("src/main/resources/countriesAndCapitals.txt"));

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
                String currentColumn1Id = currentLine[0]+"_"+column1;

                //set the answers for each field to the other fields
                ArrayList<String> currentColumn0Answers = new ArrayList<>(Arrays.asList(currentColumn1Id));
                ArrayList<String> currentColumn1Answers = new ArrayList<>(Arrays.asList(currentColumn0Id));

                //create a new Trivia in currentSet for each field
                currentSet.add(new Trivia(currentColumn0Id, column0, true, currentColumn0Answers));
                currentSet.add(new Trivia(currentColumn1Id, column1, true, currentColumn1Answers));

            }
            myScanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("currentSet has size: " + currentSet.size());
        System.out.println(currentSet.get(0).id);
        System.out.println(currentSet.get(1).id);
    }
}
