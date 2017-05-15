package crossword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Current problems include:
 * Takes much time in reading the huge text file.
 * Words come in their conjugated forms as well.
 * First words laid on the grid should be chosen randomly. This also determines the outcome of the rest of the grid.
 * Ineffective by length word picking. An example: arrays of length 6 should under index 6.. something.
 *
 * You can write in exceptions, certain letter compounds that don't exist in the language.
 * Similarly you may add certain words, which present themselves seldomly, but have unique letter compounds.
 *
 * Created by Stiv on 19/04/2017.
 */
public class WordGrabber {
    private static List<String> wordsList = new ArrayList<>();
    private String wholeString;
    private String word;
    private int[][] grid;
    private static final int MAX_WORD_LENGTH = 30;
    private String alphabet = " abcdefghijklmnopqrstuvwyz";
    private int[] wordArray;
    private List<int[]> arraysList = new ArrayList<>();
    private int columns;
    private int rows;
    private int filledSquares;
    private int row = 0;
    private int column = 0;
    private List<int[]> usedArrays = new ArrayList<>();
    private int[] partialArray;
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


    public void createGrid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
//        for (int r = 0; r < columns; r++) {
//            for (int c = 0; c < rows; c++) {
//                  this.grid[r][c] = ' ';
//            }
//        }
    }

    public void getGrid() {
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid.length; c++){
                System.out.print("[" + grid[r][c] + "]");
            }
            System.out.println();
        }
    }

    public int[] wordToArray(String word) {
        int[] wordArray = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            for (int j = 1; j < alphabet.length(); j++) {
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
        return wordArray;
    }

    public void getWordArray() {
        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(wordArray[i] + " ");
        }
    }

    public void getArraysList() {
        for (int i = 0; i < arraysList.size(); i++) {
            System.out.println(arraysList.get(i));
        }
    }


    public void getWordsArray() {
        for (int i = 0; i < arraysList.size(); i++) {
            System.out.println(Arrays.toString(arraysList.get(i)));
        }
    }

    public void addWordToRow() {
        for (int i = 0; i < wordArray.length; i++) {
            if (grid[row][i] == 0) { // if square is empty. value for empty is 0.

            }
            grid[row][i] = wordArray[i];
        }
        usedArrays.add(wordArray);
        filledSquares += wordArray.length;
        row++;
        if (column < columns) {
            addWordToColumn();
        }
    }


    public void addWordToColumn() {
        for (int r = 0; r < wordArray.length; r++) { // column's initial value is 0.
            if (grid[r][column] != 0) { // if the square isn't empty.
                for (int i = 0; i < rows - r; i++) { // will iterate till the last square included.
                    partialArray[i] = grid[r + i][column];
                }
            }
            getWordByLetters();
            usedArrays.add(wordArray);
            filledSquares += wordArray.length;
            column++;
            if (row < rows) {
                addWordToRow();
            }
        }
    }

    public void isRoom() {
//        if ()
    }
    /**
     * Returns the longest possible word to the length given, in diminishing order.
     * @param length The length of the word we are looking for.
     * @return
     */
    public int[] getCertainLengthRandomWord(int length) {
        for (int i = 0; i < arraysList.size(); i++) {
            if ((arraysList.get(i).length == length)) { // get that length word.
                wordArray = arraysList.get(i);
                return wordArray;
            }
        }
        return getCertainLengthRandomWord(length - 1); // if there isn't, get one letter shorter word.
    }

    public void addFirstWord(int length) {
        getCertainLengthRandomWord(columns);
        for (int c = 0; c < columns; c++) {
            grid[0][c] = wordArray[c];
        }
        wordArray = null; // Should empty the array, but will there be a conflict with length?
        addWordToColumn();
    }

    public void getWordByLetters() {

        for (int l = 0; l < partialArray.length; l++) {
            if (partialArray[l] != 0) { // if the square contains a letter.

            }

            for (int w = 0; w < arraysList.size(); w++) {
            }
        }
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
