import com.lex.memglobe.objects.Trivia;

import java.util.ArrayList;

public class MemGlobeApplication {


    public static void main(String[] args) {
        ArrayList<Trivia> currentSet = new ArrayList<>();
        //get path of file to import
        String file = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";

        CardSets.importAdda247(file, currentSet);

        //test run
        System.out.println("currentSet has size: " + currentSet.size());
        for (int i = 0; i < 6; i++) {
            System.out.println("Trivia.id is: " + currentSet.get(i).getId());
            currentSet.get(i).getDisplay().display();
            System.out.println("Answers:");
            currentSet.get(i).getAnswers();
        }

    }

}
