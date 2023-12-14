import com.lex.memglobe.objects.Trivia;

import java.util.ArrayList;
import java.util.Scanner;

public class MemGlobeApplication {


    public static void main(String[] args) {
        ArrayList<Trivia> currentSet = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        //get path of file to import
        String file = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";
        //create a card set from file
        CardSets.importAdda247(file, currentSet);

        //test run
        System.out.println("currentSet has size: " + currentSet.size());
        for (int i = 0; i < 13; i+=4) {
            System.out.println("----------");
            currentSet.get(i).getDisplay().display();
            myScanner.nextLine();
            System.out.println("Answers:");
            currentSet.get(i).displayAnswers();
        }

    }

}
