/**
 * Created by Stiv on 14/05/2017.
 */
public class RecArray11 {
    public String pairStar(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + pairStar(str.substring(0));
        }

    }
}
