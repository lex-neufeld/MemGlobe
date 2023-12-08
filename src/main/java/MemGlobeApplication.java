import java.util.ArrayList;

public class MemGlobeApplication {


    public static void main(String[] args) {
        ArrayList<Globe.Trivia> currentSet = new ArrayList<>();
        //get path to file to import
        String file = "src/main/resources/countriesAndCapitals.txt";

        CardSets.importList(file, currentSet);

        System.out.println("currentSet has size: " + currentSet.size());
        System.out.println("Trivia.id is: " + currentSet.get(4).id);
        currentSet.get(4).display.display();
        System.out.println("Answers:");
        currentSet.get(4).getAnswers();
        System.out.println("Answers after adding dummy to Display.audio:");
        currentSet.get(5).display.setAudio("pronunciation");
        currentSet.get(4).getAnswers();

    }

}
