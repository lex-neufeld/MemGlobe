import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;
import com.lex.memglobe.services.ImportService;
import com.lex.memglobe.services.UpdateService;

import java.util.Scanner;

public class MemGlobeApplication {


    public static void main(String[] args) {
        CardSet set1 = new CardSet("dev-set1");
        CardSet set2 = new CardSet("dev-set2");
        Scanner myScanner = new Scanner(System.in);
        //get path of file to import
        String addaFile = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";
        String geoFile = "src/main/resources/geographyfieldwork-com-capitals.txt";
        //create a card set from file
        ImportService.importAdda247(addaFile, set1);
        ImportService.importAdda247(geoFile, set2);

        System.out.println("number of nodes before merge is: " + set1.getNodes().size());
        System.out.println("Deck before merge has size: " + set1.getDeck().size());
        //get a new node
        String testNode = "uninitialized";
        for (String n : set2.getNodes().keySet()){
            if ( !set1.getNodes().containsKey(n)){
                testNode = n;
                break;
            }
        }

        UpdateService.mergeTrivia(set2, set1);

        //test run
        System.out.println("number of nodes is: " + set1.getNodes().size());
        System.out.println("Deck has size: " + set1.getDeck().size());
        for (int i = 3; i < 14; i+=4) {
            System.out.println("----------" + set1.getDeck().get(i).getSource());
            System.out.println("----------" + set1.getDeck().get(i).getSourceDate());
            set1.getDeck().get(i).getDisplay().display();
            myScanner.nextLine();
            System.out.println("Answers:");
            set1.getDeck().get(i).displayAnswers();
        }

        //small test of source and sourceDate



        //small test of nodes HashMap
        System.out.println(set1.getNodes().get(testNode));
        System.out.println(set2.getNodes().get(testNode));
        for (Trivia trivia : set1.getNodes().get(testNode)){
            System.out.println("----for node------" + trivia.getSource());
            System.out.println("----for node------" + trivia.getSourceDate());
            trivia.getDisplay().display();
            myScanner.nextLine();
            System.out.println("Answers:");
            trivia.displayAnswers();
        }
    }
}
