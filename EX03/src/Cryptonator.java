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

    /**
     * Given text and a rotation, encrypts text.
     * @param plainText plain text, readable by humans
     *                  with relative ease.
     * @param rotation the number of steps in alphabetical order, a letter will be changed in value.
     * @return encrypted text
     */
    public static String encrypt(String plainText, int rotation) {
        String encryption = "";
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
                // perfect!
                System.out.println(stringAlphabet.indexOf((plainText.toLowerCase()).charAt(c)));
                encryption += stringAlphabet.indexOf((plainText.toLowerCase()).charAt(c))
                        - (rotation % NUM_LETTERS_ALPHABET);
            }
        }
        return null;
    }

    /**
     * Finds the most infrequently occurring letter in text.
     * @param text either plain or encrypted text.
     * @return the most infrequently occurring letter in text.
     * If there is no such letter, return 0.
     */
    public static char findMostInfrequentlyOccurringLetter(String text) {
        // TODO: implement
        return 0;
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
        System.out.println("you too Brutus?" + " (is the plain text - not encrypted message)");
        System.out.println("iye dyy ledec?" + " (is the right outcome)");
        encrypt("you too Brutus?", 3);
    }
}