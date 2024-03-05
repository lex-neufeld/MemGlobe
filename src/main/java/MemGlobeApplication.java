import com.lex.memglobe.objects.CardSet;
import com.lex.memglobe.objects.Trivia;
import com.lex.memglobe.services.DeckBrowser;
import com.lex.memglobe.services.ImportService;
import com.lex.memglobe.services.UpdateService;

import javax.swing.*;
import java.util.Scanner;

public class MemGlobeApplication {


    public static void main(String[] args) {
        CardSet set1 = new CardSet("dev-set1");
        CardSet set2 = new CardSet("dev-set2");
        Scanner myScanner = new Scanner(System.in);
        //get path of file to import
        String addaFile = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";
        String geoFile = "src/main/resources/geographyfieldwork-com-capitals.txt";

        //create card sets from files
        System.out.println("Importing " + addaFile + " to set1.");
        ImportService.importAdda247(addaFile, set1);
        System.out.println("number of nodes in set1 before merge is: " + set1.getClusters().size());
        System.out.println("set1 Deck before merge has size: " + set1.getDeck().size());

        System.out.println("Importing " + geoFile + " to set2.");
        ImportService.importAdda247(geoFile, set2);

        // for later testing of nodes
        // iterate through the nodes of set 2 until we find a "new" one that isn't in set 1
        // do this before merging the sets
        String testNode = "uninitialized";
        for (String n : set2.getClusters().keySet()){
            if ( !set1.getClusters().containsKey(n)){
                testNode = n;
                break;
            }
        }
        System.out.println(testNode);

        //merge card sets
        System.out.println("merging set2 into set1");
        UpdateService.mergeTrivia(set2, set1);

        DeckBrowser deckBrowser = new DeckBrowser(set1);
        deckBrowser.setContentPane(deckBrowser.getPanelDeckBrowser());
        deckBrowser.setTitle("Deck Browser");
        deckBrowser.setVisible(true);
        deckBrowser.setSize(500,500);
        deckBrowser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //test run
        System.out.println();
        System.out.println("test run set1");
        System.out.println("number of nodes is: " + set1.getClusters().size());
        System.out.println("Deck has size: " + set1.getDeck().size());
        for (int i = 3; i < 13; i+=4) {
            //small test of source and sourceDate
            System.out.println("from source: " + set1.getDeck().get(i).getSource());
            System.out.println("on date: " + set1.getDeck().get(i).getSourceDate());
            System.out.println(set1.getDeck().get(i).getQuestion());
            myScanner.nextLine();
            System.out.println(set1.getDeck().get(i).displayAnswers());

        }



        // small test of nodes HashMap
        // iterate through node testNode
        for (Trivia trivia : set1.getClusters().get(testNode)){
            System.out.println(trivia.getQuestion());
            myScanner.nextLine();
            System.out.println(trivia.displayAnswers());
        }
    }
}
