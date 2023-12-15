import com.lex.memglobe.objects.Trivia;

import java.util.ArrayList;
import java.util.Scanner;

public class MemGlobeApplication {


    public static void main(String[] args) {
        ArrayList<Trivia> currentSet = new ArrayList<>();
        ArrayList<String> currentNodes = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        //get path of file to import
        String file = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";
        //create a card set from file
        CardSets.importAdda247(file, currentSet, currentNodes);

        //test run
        System.out.println("number of nodes is: " + currentNodes.size());
        System.out.println("currentSet has size: " + currentSet.size());
        for (int i = 0; i < 12; i+=4) {
            System.out.println("----------");
            currentSet.get(i).getDisplay().display();
            myScanner.nextLine();
            System.out.println("Answers:");
            currentSet.get(i).displayAnswers();
        }
        //small test of nodes
        for (Trivia trivia : currentSet){
            if (trivia.getNode().equals(currentNodes.get(127))){
                System.out.println("----for node------");
                trivia.getDisplay().display();
                myScanner.nextLine();
                System.out.println("Answers:");
                trivia.displayAnswers();
            }

        }

    }

}
