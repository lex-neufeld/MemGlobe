//this class is for data structure and relationships and evaluating those relationships
import java.util.ArrayList;


public class Globe {
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
}
