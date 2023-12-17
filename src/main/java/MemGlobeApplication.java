import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;
import com.lex.memglobe.services.ImportService;

import java.util.Scanner;

public class MemGlobeApplication {


    public static void main(String[] args) {
        CardSet currentSet = new CardSet("devset");
        Scanner myScanner = new Scanner(System.in);
        //get path of file to import
        String file = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";
        //create a card set from file
        ImportService.importAdda247(file, currentSet);

        //test run
        System.out.println("number of nodes is: " + currentSet.getNodes().size());
        System.out.println("currentSet has size: " + currentSet.getDeck().size());
        for (int i = 0; i < 12; i+=4) {
            System.out.println("----------");
            currentSet.getDeck().get(i).getDisplay().display();
            myScanner.nextLine();
            System.out.println("Answers:");
            currentSet.getDeck().get(i).displayAnswers();
        }
        //small test of nodes
        for (Trivia trivia : currentSet.getDeck()){
            if (trivia.getNode().equals(currentSet.getNodes().get(127))){
                System.out.println("----for node------");
                trivia.getDisplay().display();
                myScanner.nextLine();
                System.out.println("Answers:");
                trivia.displayAnswers();
            }

        }

    }

}
