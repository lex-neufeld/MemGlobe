import java.util.ArrayList;

public class MemGlobeApplication {


    public static void main(String[] args) {
        ArrayList<Globe.Trivia> currentSet = new ArrayList<>();
        //get path of file to import
        String file = "src/main/resources/adda247-com-countries-capital-and-currencies.txt";

        CardSets.importAdda247(file, currentSet);

        System.out.println("currentSet has size: " + currentSet.size());

        for (int i = 0; i<6;i++){
            System.out.println("Trivia.id is: " + currentSet.get(i).id);
            currentSet.get(i).display.display();
            System.out.println("Answers:");
            currentSet.get(i).getAnswers();
        }

    }

}
