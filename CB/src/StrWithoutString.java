import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 09/05/2017.
 */
public class StrWithoutString {
    public static String withoutString(String base, String remove) {
        char[] baseChars = base.toCharArray();
        String lowRemove = remove.toLowerCase();
        char[] chars = lowRemove.toCharArray();
        List<Integer> positions = new ArrayList<>();

        String low = base.toLowerCase();
        String newStr = low.replace(lowRemove, "");
        char[] newStrChars = newStr.toCharArray();

        int j = 0;
        String c;
        String li;
        String lj;
        if (newStrChars.length == 0) {
            return "";
        }
        for (int i = 0; i < base.length(); i++) {
            /* If the character from the shortened string is the same, but in lowercase from the other string. */
            c = String.valueOf(baseChars[i]);
            li = c.toLowerCase();
            lj = String.valueOf(newStrChars[j]);
            if (lj.equals(li)) {
                newStrChars[j] = base.charAt(i);
                if (j == newStrChars.length - 1) {
                    break;
                }
                j++;
            }

        }
        newStr = String.valueOf(newStrChars);
        return newStr;
    }
    public static void main(String[] args) {
        StrWithoutString instance = new StrWithoutString();
//        System.out.println(instance.withoutString("Hello there", "llo"));
//        System.out.println(instance.withoutString("Hello there", "e"));
        System.out.println(instance.withoutString("xxx", "x"));
    }
}
