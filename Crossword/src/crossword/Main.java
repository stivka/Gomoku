package crossword;

import static crossword.WordGrabber.stringFromUrl;

/**
 * Created by Stiv on 09/05/2017.
 */
public class Main {
    /**
     *
     * @param args sth.
     */
    public static void main(String[] args) {
        WordGrabber wordGrab = new WordGrabber();
        wordGrab.start();
    }

    /**
     * I made a non static method, so I could use my global non-static
     * variable (eg. wholeString).
     */
    public void start() {
        stringFromUrl("http://norvig.com/big.txt", 1000);
        wordFromString(wholeString);
        getWords();

    }
}
