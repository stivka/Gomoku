/**
 * Created by Stiv on 14/02/2017.
 */
public class Cryptonator {
    /**
     * Alphabet array with indexes of 0 to 25 that means there's 26 letters in the English alphabet.
     */
    public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static String stringAlphabet = "abcdefghijklmnopqrstuvwxyz";
    public static final int NUM_LETTERS_ALPHABET = 26;
//    public static int[] frequency = new int[NUM_LETTERS_ALPHABET];

    /**
     * Given text and a rotation, encrypts text.
     * @param plainText plain text, readable by humans
     *                  with relative ease.
     * @param rotation the number of steps in alphabetical order, a letter will be changed in value.
     * @return encrypted text
     */
    public static String encrypt(String plainText, int rotation) {
        String encryption = "";
        int index = 0;
        if (plainText == null) {
            return null;
        }
        if (plainText.equals("")) {
            return "";
        }

        plainText.toLowerCase();
        System.out.println((plainText.toLowerCase() + " (.. in lowercase)"));

        for (int c = 0; c < plainText.length(); c++) {
//            System.out.print(stringAlphabet.indexOf(c));
            if (Character.isLetter(plainText.charAt(c))) {
                /* perfect! index equals to the lowercase character index number in accordance to the alphabet string.
                the rotation is also applied, which is divided by modulus to eliminate whole cycles - from a (index  0)
                - 27 should do one cycle and - 1, landing on z. Which divided with modulus would give (27 % 26 = 1) a
                plain 1, implying that the operation merely be - 1.
                */
                System.out.print(stringAlphabet.indexOf((plainText.toLowerCase()).charAt(c)) + " ");
                index = stringAlphabet.indexOf((plainText.toLowerCase()).charAt(c))
                        - (rotation % NUM_LETTERS_ALPHABET);
                if (index < 0) {
                    index = NUM_LETTERS_ALPHABET + index; // a, rotation 1 -> 26 + (-1) = 25, 25 = z (by index)
                    encryption += stringAlphabet.charAt(index);
                } else {
                    encryption += stringAlphabet.charAt(index);
                }
            } else {
                encryption += plainText.charAt(c);
            }
        }
        System.out.println("\n" + encryption + " (is what i got)");
        findMostInfrequentlyOccurringLetter(encryption);
        return encryption;
    }

    /**
     * Finds the most infrequently occurring letter in text.
     * @param text either plain or encrypted text.
     * @return the most infrequently occurring letter in text.
     * If there is no such letter, return 0.
     */
    public static char findMostInfrequentlyOccurringLetter(String text) {
        int[] frequency = new int[NUM_LETTERS_ALPHABET];
        char mostInfrequentChar = '!';
        boolean printed = false;
        int minCount = text.length() + 1; /* count of the smallest value that a letter occurs so far. Set at maximum
        value, which is that all characters of that string are that letter, plus one, so that .*/
        System.out.println("Down below are shown the occurrence counts of letters.");
        // This cycle counts every occurrence of every letter.
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                frequency[stringAlphabet.indexOf(text.charAt(i))] += 1;
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
            if (frequency[k] > 0 && frequency[k] <= minCount) {
                minCount = frequency[k];
                break;
            } else if (frequency[k] < minCount && k == frequency.length - 1) {
                /* If one letter has occurred at least once, but less times than any other letter from the whole
                 alphabet that has occurred at least once,If one letter has not occurred more than once from the whole alphabet.

                */
                System.out.println("\nAll chars occur only once. There isn't a least frequent char.");
                return 0;
            }

        }
        // This cycle returns the first character in alphabetical order, that occurs the least.
        for (int l = 0; l < frequency.length; l++) {
            if (frequency[l] == minCount) {
                mostInfrequentChar = stringAlphabet.charAt(l);
                break;
            }
        }
        System.out.println("\nMost infrequent char in the order of the alphabet is: " + mostInfrequentChar);
        return mostInfrequentChar;
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
                frequency[stringAlphabet.indexOf(text.charAt(i))] += 1;
            }
        }
        for (int j = 0; j < frequency.length; j++) {
            System.out.print(frequency[j] + " ");
        }
        for (int k = 0; k < frequency.length; k++) {
            if (frequency[k] > mostFrequentCharCount) {
                mostFrequentCharCount = frequency[k];
                mostFrequentChar = stringAlphabet.charAt(k);
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
        // TODO: implement
        return null;
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
        // TODO: implement
        return null;
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
        /**"you too Brutus?" krüpteerituna kasutades nihet 3, oleks: "iye dyy ledec?"
         Peale krüpteerimist esineb tähti "i", "l", "b", "c" kõik üks kord. "b" on tähestikus kõige eespool,
         seepärast eemaldatakse tulemusest "b" (algselt "r" täht).
         */

        System.out.println("\"you too Brutus?\" (is the plain text - not encrypted message)\n" +
                "\"iye dyy ledec?\" (is the right outcome with a rotation 16)");
        encrypt("you too Brutus?", 16);

        System.out.println("\n\"you too Brutus?\" on a rotation 1, should give \n\"xnt snn aqtstr?\"");
        encrypt("you too Brutus?", 1);

        System.out.println("\nExample when all letters occur only once. And on a high rotation \"Love Hurts\", " +
                "on a rotation of 40 000");
        encrypt("Love Hurts", 40000);

        System.out.println("\nAnother example when ALL letters occur TWICE! And only twice! Also testing a negative" +
                " rotation. \"Couscous\", on a rotation of -1");
        encrypt("Couscous", -1);
    }
}