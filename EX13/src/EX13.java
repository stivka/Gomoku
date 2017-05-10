/**
 * Created by Stiv on 10/05/2017.
 */
public class EX13 {
    /**
     *
     * @param str String which is 'passed through'.
     * @param word  String which is searched for within str.
     * @return + sign, or word, or "".
     */
    public static String plusOut(String str, String word) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() < word.length()) {
            return "+" + plusOut(str.substring(1), word);
        }
        if (str.substring(0, word.length()).equals(word)) {
            return word + plusOut(str.substring(word.length()), word);
        }
        return "+" + plusOut(str.substring(1), word);
    }

    /**
     *
     * @param args main arguments.
     */
    public static void main(String[] args) {
        EX13 insta = new EX13();
        System.out.println((insta.plusOut("12ab34", "ab")));
        System.out.println(insta.plusOut("12ab34", "1"));
        System.out.println(insta.plusOut("aabcaaabaav", "aa"));
    }
}
