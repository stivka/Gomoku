
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Current problems include:
 * Takes much time in reading the huge text file.
 * Words come in their conjugated forms.
 * Created by Stiv on 19/04/2017.
 */
public class WordGrabber {
    private List<String> wordsList = new ArrayList<>();
    private String wholeString;
    private String word;
    private char[][] grid;
    private static final int MAX_WORD_LENGTH = 30;
    private String alphabet = "abcdefghijklmnopqrstuvwyz";
    private int[] wordArray;
    private List<int[]> wordsArray = new ArrayList<>();
//    private int[] wordArray = new int[];

    /**
     *
     * @param url The URL of the website, from where you are going to
     *            pull the text from.
     *
     * @param lineCount The number of lines you are going use from this
     *                  text file.
     */
    public void stringFromUrl(String url, int lineCount) {
        try {

            URL url1 = new URL(url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url1.openStream()));

            this.wholeString = ""; // clears the string.
            String inputLine;

            /*
            Stores lineCount lines of text.
             */
            for (int i = 0; i < lineCount; i++) {
                if ((inputLine = in.readLine()) != null) {
                    wholeString += " " + inputLine;
                }
            }
//            System.out.println(wholeString);
            in.close();

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

    /**
     * Chops the string into words, and puts the words in an ArrayList.
     * @param wholeString Is the String of lineCount * lines (from the
     *                    text).
     */
    public void wordFromString(String wholeString) {

        wholeString = wholeString.toLowerCase();

        this.word = "";

        for (int i = 0; i < wholeString.length(); i++) {
            char c = wholeString.charAt(i);
            if (Character.isLetter(wholeString.charAt(i))) {
                word += wholeString.charAt(i);
            } else if (Character.isWhitespace(wholeString.charAt(i)) && word.length() > 0) {
//                wordsList.add(word);
                addWord(word);
                word = ""; // clears String
                        /*
                If the Character ain't a letter nor a whitespace, it
                should be a punctuation mark or a digit, or a formatting
                symbol. None a symbol which forms a word.
                 */
            } else if (word.length() > 0) {
//                wordsList.add(word);
                addWord(word);
                word = "";
            }
        }


    }

    /**
     * Next step is making sure, I get only one instance of each word.
     * @param word The String word extracted from the wholeString.
     */
    public void addWord(String word){
        if (!wordsList.contains(word)) {
            wordsList.add(word);
        }
    }

    public void getWords() {
        java.util.Collections.sort(wordsList);
        wordsList.forEach(System.out::println);
        System.out.println("Currently there are " + wordsList.size()
        + " words in the list.");
    }

    public void createGrid(int rows, int columns) {
        this.grid = new char[rows][columns];
        for (int r = 0; r < columns; r++) {
            for (int c = 0; c < rows; c++) {
                  this.grid[r][c] = ' ';
            }
        }
    }

    public void getGrid() {
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid.length; c++){
                System.out.print("[" + grid[r][c] + "]");
            }
            System.out.println();
        }
    }

    public void wordToArray(String word) {
        int[] wordArray = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            for (int j = 0; j < alphabet.length(); j++) {
                char alphaChar = alphabet.charAt(j);
                /*
                Places the corresponding letter index from the alphabet
                to the same letter position in the wordArray.
                 */
                if (wordChar == alphaChar) {
                    wordArray[i] = alphabet.indexOf(alphaChar);
                    break;
                }
            }
        }
        this.wordArray = wordArray;
        //        System.out.println(wordArray);
    }

    public void getWordArray() {
        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(wordArray[i] + " ");
        }
    }

    public void convertWordsToArrays() {
        for (int i = 0; i < wordsList.size(); i++) {
            wordToArray(wordsList.get(i));

            wordsArray.add(wordArray);
        }
    }

    public void getWordsArray() {
//        Arrays.toString(wordsArray);
        for (int i = 0; i < wordsArray.size(); i++) {
            System.out.println(Arrays.toString(wordsArray.get(i)));
        }
//        System.out.println(Arrays.deepToString(wordsArray));
    }



    /**
     *
     * @param args sth.
     */
    public static void main(String[] args) {
        WordGrabber wordGrab = new WordGrabber();
        wordGrab.start();

//        String s = "and";
//        System.out.println(s.toCharArray());

//        wordGrab.wordToArray("and");
//        wordGrab.getWordArray();
    }

    /**
     * I made a non static method, so I could use my global non-static
     * variable (eg. wholeString).
     */
    public void start() {
        stringFromUrl("http://norvig.com/big.txt", 1000);
        wordFromString(wholeString);
//        getWords();
        createGrid(10, 10);
//        getGrid();
        convertWordsToArrays();
        getWordsArray();

    }
}
