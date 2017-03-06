/**
 * Created by Stiv on 14/02/2017.
 */
import java.util.ArrayList;
public class Cryptonator {
    /**
     * Alphabet string with indexes of 0 to 25 that means there's 26 letters in the English alphabet.
     */
    public static final String STRING_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    /**
     * The number of letters in the English alphabet.
     */
    public static final int NUM_LETTERS_ALPHABET = 26;

    /**
     * Given text and a rotation, encrypts text.
     * @param plainText plain text, readable by humans
     *                  with relative ease.
     * @param rotation the number of steps in alphabetical order, a letter will be changed in value.
     * @return encrypted text
     */
    public static String encrypt(String plainText, int rotation) {
        // Detects if the method was called out by decrypt, in which case the minimize method shall not be called upon.
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        boolean decrypt = false;
        for (int i = 0; i < stackTraceElements.length; i++) {
            if (stackTraceElements[i].getMethodName() == "decrypt") {
                decrypt = true;
            }
        }
        System.out.println(stackTraceElements);
        String encryption = "";
//        char mostInfrequentChar = 'a';
        int newIndexInAlphabet = 0;
        if (plainText == null) {
            return null;
        }
        if (plainText.equals("")) {
            return "";
        }
        plainText.toLowerCase();
        System.out.println((plainText.toLowerCase() + " (.. in lowercase)"));
        System.out.println("Down below is the text re-written in indexes, and omitting anything but letters.");
        for (int c = 0; c < plainText.length(); c++) {
            if (Character.isLetter(plainText.charAt(c))) {
                /* perfect! newIndexInAlphabet equals to the lowercase character newIndexInAlphabet number in accordance to the alphabet string.
                the rotation is also applied, which is divided by modulus to eliminate whole cycles - from a (newIndexInAlphabet  0)
                - 27 should do one cycle and - 1, landing on z. Which divided with modulus would give (27 % 26 = 1) a
                plain 1, implying that the operation merely be - 1.
                */
                System.out.print(STRING_ALPHABET.indexOf((plainText.toLowerCase()).charAt(c)) + " ");
                newIndexInAlphabet = ((STRING_ALPHABET.indexOf((plainText.toLowerCase()).charAt(c))
                        + (rotation % NUM_LETTERS_ALPHABET)) % NUM_LETTERS_ALPHABET);
                if (newIndexInAlphabet < 0) { // for decryption, when rotation goes negative.
                    encryption += STRING_ALPHABET.charAt(NUM_LETTERS_ALPHABET + newIndexInAlphabet);
                } else {
                    encryption += STRING_ALPHABET.charAt(newIndexInAlphabet);
                }
            } else {
                encryption += plainText.charAt(c);
            }
        }
        System.out.println("\n" + encryption + " (is the text encrypted with rotation " + rotation + " applied, " +
                "without any minimization)");
        // which can be the encrypted message or the decrypted message.
        if (decrypt) {
            return encryption;
        }
        return minimizeText(encryption);
        }

        /**
         * Finds the most infrequently occurring letter in text.
         * @param text either plain or encrypted text.
         * @return the most infrequently occurring letter in text.
         * If there is no such letter, return 0.
         */

    public static char findMostInfrequentlyOccurringLetter(String text) {
        int[] frequency = new int[NUM_LETTERS_ALPHABET];
        char mostInfrequentLetter = 'a';
        int minCount = text.length() + 1; /* count of the smallest value that a letter occurs so far. Set at maximum
        value, which is that all characters of that string are that letter, plus one, so that .*/
        System.out.println("Down below are shown the occurrence counts of letters.");
        // This cycle counts every occurrence of every letter.
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                frequency[STRING_ALPHABET.indexOf(text.charAt(i))] += 1;
            }
        }
        // This cycle prints how many counts there are per letter's position in the alphabet.
        for (int j = 0; j < frequency.length; j++) {
            System.out.print(frequency[j] + " ");
        }
        /* In this loop it is checked whether there is one letter that occurs more than others. This is necessary
           to determine that there even is a most infrequently occurring letter, because if all letters occur only once
           like for example "Love hurts" - then there can't be a most infrequent letter. But if the message was "Love
           doesn't hurt" - then we already get letters like o, e and t, that occur more than once, leaving us with the
           distinction that there are letters, which on the other hand, occur only once.*/
        for (int k = 0; k < frequency.length; k++) {
            if (frequency[k] > 0 && frequency[k] < minCount) {
                minCount = frequency[k];
                mostInfrequentLetter = STRING_ALPHABET.charAt(k);
            /*} else if (frequency[k] < minCount && k == frequency.length - 1) {
                /* If one letter has occurred at least once, but less times than any other letter from the whole
                 alphabet that has occurred at least once,If one letter has not occurred more than once from the whole alphabet.
                System.out.println("\nAll chars occur only once. There isn't a least frequent char.");
                return 0; */
            }

        }
        System.out.println("\nMost infrequent char in the order of the alphabet is: " + mostInfrequentLetter);
        return mostInfrequentLetter;
    }

    /**
     * By mistake created this method for finding the most FREQUENTLY, not infrequently, occurring character.
     * @param text is the encrypted string.
     * @return the most frequently occurring character or 0 if all characters occur only once.
     */
    public static char findMostFrequentlyOccurringLetter(String text) {
        int[] frequency = new int[NUM_LETTERS_ALPHABET];
        int mostFrequentCharCount = -1;
        char mostFrequentChar = '!';
        System.out.println("Down below are shown the occurrence counts of letters.");
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                frequency[STRING_ALPHABET.indexOf(text.charAt(i))] += 1;
            }
        }
        for (int j = 0; j < frequency.length; j++) {
            System.out.print(frequency[j] + " ");
        }
        for (int k = 0; k < frequency.length; k++) {
            if (frequency[k] > mostFrequentCharCount) {
                mostFrequentCharCount = frequency[k];
                mostFrequentChar = STRING_ALPHABET.charAt(k);
            }
        }
        if (mostFrequentChar == 1) {
            return 0;
        } else {
            System.out.println("\n" + mostFrequentChar);
            return mostFrequentChar;
        }
    }

    /**
     * Removes the most infrequent letter from text.
     * @param text either plain or encrypted text.
     * @return text in which the rarest letter has been removed.
     */
    public static String minimizeText(String text) {
        char mostInfrequentLetter = findMostInfrequentlyOccurringLetter(text);
        text = text.replaceAll(String.valueOf(mostInfrequentLetter), "");
        System.out.println(text + " (with rarest letter removed. This is the FINAL encrypted message.)");
        return text;
    }

    /**
     * Given the initial rotation and the encrypted text, this method
     * decrypts said text.
     * @param cryptoText Encrypted text.
     * @param rotation How many letters to the right the alphabet was
     *                 shifted in order to encrypt text.
     * @return Decrypted text.
     */
    public static String decrypt(String cryptoText, int rotation) {
        return encrypt(cryptoText, -rotation);
    }

    /**
     * NB! This is a bonus task.
     *
     * Given the crypted message and words in dictionary,
     * find the original message with the highest score.
     * Returns the best score.
     *
     * The score is calculated as follows:
     * - the message is decrypted, the abs(rotation) used
     * is taken off from the score (the smaller the rotation,
     * the better the score).
     * Note: the rotation can also be negative.
     *
     * - in the decrypted message, each word existing in the dictionary
     * adds the score which is equal to the letters in the word in dictionary.
     *
     * Score = sum([w.length for w in dictionary and w in decrypted message]) - rotation used
     *
     * Example:
     * message "aaa abc"
     * dictionary: {"bbb", "ccc"}
     *
     * When using rotation 25, we get: "bbb bcd"
     * We would get the same when using -1: "bbb bcd"
     * The score for -1 rotation would be: 3 - 1 = 2
     * 3 is the length of matching word "bbb".
     * 1 is abs(rotation) = abs(-1)
     *
     * When rotating using -2, we would get "ccc cde"
     * The score: 3 - 2 = 1.
     *
     * So, the best score is 2.
     *
     * @param cryptedMessage Crypted message.
     * @param dictionary Dictionary of possible words.
     * @return The best score for original message.
     */
    public static int getDecryptionScore(String cryptedMessage, String[] dictionary) {
        return -1;
    }

    /**
     * The main method, which is the entry point of the program.
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        decrypt("abcd", 2);
//encrypt("aabbaa7", 10);
//                encrypt("aa", 10);
//        System.out.println("aa minimized should be []");
//        minimizeText("7 a3v-o1dp");
//        System.out.println("string to minimize is \"7 a3v-o1dp\" ");
//        /*FAILURE: testMinimizeRandom10
//        1 msecs, unit test weight: 1 units
//        Exception type: class java.lang.AssertionError
//        Detailed information:  expected [7 3v-o1dp] but found [7 c3-o1dp] */
//
//            encrypt("ru1ueytmw1", 0);
//        System.out.println("should remove e..");
//
//        encrypt("woo wee woo wee woooooo mwhaasdijaoidwa", 0);
//        System.out.println("expects woo wee woo wee woooooo mwaasdijaoidwa");
//        decrypt("a", 0); // works for me, test shows [null]
//
//        System.out.println("\"iye dyy ledec?\" is the encrypted message. " +
//                "+\nThe rotation was 16 and the original message was \"you too Brutus?\"");
//        decrypt("iye dyy ledec?", 16);
//
//        System.out.println("\"you too Brutus?\" (is the plain text - not encrypted message)\n" +
//                "\"iye dyy ledec?\" (is the right outcome with a rotation 16)");
//        encrypt("you too Brutus?", 16);
//
//        System.out.println("\n\"you too Brutus?\" on a rotation 1, should give \n\"xnt snn aqtstr?\"");
//        encrypt("you too Brutus?", 1);
//
//        System.out.println("\nExample when all letters occur only once. And on a high rotation \"Love Hurts\", " +
//                "on a rotation of 40 000");
//        encrypt("Love Hurts", 40000);
//
//        System.out.println("\nAnother example when ALL letters occur TWICE! And only twice! Also testing a negative" +
//                " rotation. \"Couscous\", on a rotation of -1");
//        encrypt("Couscous", -1);
    }
}