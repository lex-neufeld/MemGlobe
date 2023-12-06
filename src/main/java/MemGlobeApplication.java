import java.util.ArrayList;

public class MemGlobeApplication {


    public static void main(String[] args) {
        ArrayList<Globe.Trivia> currentSet = new ArrayList<>();
        //get path to file to import
        String file = "src/main/resources/countriesAndCapitals.txt";

        CardSets.importList(file, currentSet);

        System.out.println("currentSet has size: " + currentSet.size());
        System.out.println(currentSet.get(4).id);
        System.out.println(currentSet.get(4).answers);
        System.out.println(currentSet.get(11).id);
        System.out.println(currentSet.get(11).answers);
    }

}
