
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
    private List<String> wordsList = new ArrayList<>();
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

    public void getWords() {
        java.util.Collections.sort(wordsList);
        wordsList.forEach(System.out::println);
        System.out.println("Currently there are " + wordsList.size()
        + " words in the list.");
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

    public void convertWordsToArrays() {
        /* Adds 3 words to begin with to the arraysList, so comparing can be done from here forward.*/
        wordToArray(wordsList.get(0));
        arraysList.add(wordArray);
        wordsList.remove(0); // Removes the word from the list, shortening the list.
        wordToArray(wordsList.get(0));
        arraysList.add(wordArray);
        wordsList.remove(0);
        wordToArray(wordsList.get(0));
        arraysList.add(wordArray);
        wordsList.remove(0);

        /* Loops until there are now more words left in the wordsList. Grabs first word from wordsList to place in the
        arraysList list. Converts the word into an int[], and stores it in the wordArray global variable.*/
        while (wordsList.size() > 0) {

            int wli = 0; // word list index.
            int wli = 0;

            int minDifference = 26; // impossibly big difference. static final int impossible difference.

            int lwl; // list word letter.
            int pwl; // placeable word letter

            int[] closestMatch1Array;
            int closestMatch1ArrayIndex;

            int closestMatch1SameLetters = 0; // same letters - exactly same letters in order

            int shorterWordLength = 1;

            /* Size -2 since it takes the value of l AND l + 2. Also there are two arrays in the list to start with
            so that there wouldn't be a conflict.*/
            for (int ali = 0; ali < arraysList.size() - 2; ali++) {
                /* Also if placeable word array length is larger than the list word length. E.g. Antler vs. Ant - so as
                to avoid conflicts, we must write a try catch or sth. similar.. Also there CAN'T be identical words in
                the wordList, so no conflicts on that part. */
                for (wli = 0; wli < shorterWordLength; wli++) {

                    shorterWordLength = Math.min(arraysList.get(ali).length, wordToArray(wordsList.get(wli)).length);
                    /* Assigns the first arrayList item, as the closest match (SO FAR). */
                    closestMatch1Array = arraysList.get(ali);
                    closestMatch1ArrayIndex = ali;

                    lwl = arraysList.get(ali)[wli];
                    lnwl = arraysList.get(ali + 1)[wli];
                    pwl = wordArray[wli];



                    /* If it is the same letter, go on taking the next letters of these words. It then determines
                    still whether it is before or after this word by comparing the next letters of each word. The break
                     keyword just makes it iterate through the inner for loop again, meaning it takes the next letter
                     positions. */
                    if (lwl == pwl) {
                        closestMatch1SameLetters++;
                        closestMatch1Array = arraysList.get(ali);
                        break;
                    }
                    /* */
                    if (lwl < pwl && closestMatch1SameLetters == 0 && ) {

                    }
                    /* Check next word if there is a match on letter level. */
                    if (lwl < pwl && closestMatch1SameLetters > 0) {
                        ali++;
                    }
                    /* else lwl > pwl. That means that placeable word array will be put instead of the closest match
                    array pushing the closest match and rest of the list behind it forward.*/
                    else {
                        arraysList.add(closestMatch1ArrayIndex, closestMatch1Array);
                    }
                }
            }
        }
    }

//                if (wordArray[a] == arraysList.get(l)[a]) {
//                        if (sidesChecked <= 1) {
//                            sidesChecked = 1;
//                            sideArray = arraysList.get(l);
//                            side1++;
//                        }
//                        /* Checks whether one side is already checked and if we are now checking the second array,
//                        namely another array but the one we checked before.*/
//                        if (sidesChecked >= 1 && arraysList.get(l) != sideArray) {
//                            sidesChecked = 2;
//                            side2Array = arraysList.get(l);
//                            side2++;
//                        }
//                        if (sidesChecked >= 2 && arraysList.get(l) != side2Array) {
//                            sidesChecked = 3;
//                            side3++;
//                        }
//                        /* If no more letters match and all 3 sides have been checked. Then  */
//                    }
//                    /* Secondly, if the letters aren't equal letters, it checks whether the letter can come after the
//                    * all the letters in that position. It starts the same for loop again, looking for the closest value
//                    * it is smaller of. */
//                    if (wordArray[a] > arraysList.get(l)[a]) {
//                        for (int a2 = a; a < arraysList.size(); a2++) {
//
//                        }
//                    }
//                    /* Thirdly, if the letters of that position are not equal. If the letter from the word to be placed
//                    * does not come after any letter of that position, it must come before.*/
//                    /* Will be added before the word it was compared to. */
//                    else {
//
//                    }
//                    if (wordArray[a] < arraysList.get(l)[a] && sidesChecked) {
//                        break;
//                    }
//                    if (wordArray[a] > arraysList.get(l)[a] && sidesChecked) {
//                        break;
//                    }







    public void closetValue() {
        int[] numbers = new int[10];
        numbers[0] = 100;
        numbers[1] = -34200;
        numbers[2] = 3040;
        numbers[3] = 400433;
        numbers[4] = 500;
        numbers[5] = -100;
        numbers[6] = -200;
        numbers[7] = 532;
        numbers[8] = 6584;
        numbers[9] = -945;

        int myNumber = 490;
        int distance = Math.abs(numbers[0] - myNumber);
        int idx = 0;
        for (int c = 1; c < numbers.length; c++){
            int cdistance = Math.abs(numbers[c] - myNumber);
            if (cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        int theNumber = numbers[idx];
        System.out.println(theNumber);
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
        getWords();
//        createGrid(10, 10);
//        getGrid();

//        String[] array = {"and", "ant", "anti"};
//        for (int i = 0; i < array.length; i++) {
//            wordsList.add(array[i]);
//        }

        //        convertWordsToArrays();
//        getWordsArray();
//        addFirstWord(columns);
//        getGrid();

        closetValue();

    }
}
