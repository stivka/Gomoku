package crossword;
/**
 * Created by Stiv on 19/04/2017.
 */
public class Crossword {
    public void getWords() {
        java.util.Collections.sort(wordsList);
        wordsList.forEach(System.out::println);
        System.out.println("Currently there are " + wordsList.size()
                + " words in the list.");
    }

}
