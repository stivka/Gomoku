import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 19/05/2017.
 */
public class Str {
    public int countYZ(String str) {
        int count = 0;
        String loweredStr = str.toLowerCase();
        char[] chars = loweredStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                chars[i] = ' ';
            }
        }
        String newStr = String.valueOf(chars);
        for (String word: newStr.split(" ")) {
            if (word.endsWith("y") || word.endsWith("z")) {
                count++;
            }
        }
        return count;
    }

    public String withoutString(String base, String remove) {
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

    public boolean equalIsNot(String str) {
        char[] chars = str.toCharArray();
        int isCount = 0;
        int notCount = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'i' && chars[i + 1] == 's') {
                isCount++;
            }
        }
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == 'n' && chars[i + 1] == 'o'
                    && chars[i + 2] == 't') {
                notCount++;
            }
        }
        return isCount == notCount;
    }

    public boolean gHappy(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'g' && count == 1) {
                return false;
            }
            else if (str.charAt(i) == 'g') {
                count++;
            }
            else {
                count = 0;
            }
        }
        if (count == 1) {
            return false;
        }
        return true;
    }

    public int countTriple(String str) {
        int i = 0;
        int tripleCount = 0;
        while (i < str.length() - 1) {
            char ic = str.charAt(i);
            int j = i + 1;
            int letterCount = 1;
            while (j < str.length()) {
                char jc = str.charAt(j);
                if (str.charAt(i) == str.charAt(j)) {
                    letterCount++;
                    j++;
                    if (j == str.length()) {
                        if (letterCount >= 3) {
                            tripleCount += letterCount - 2;
                        }
                        return tripleCount;
                    }
                } else {
                    if (letterCount >= 3) {
                        tripleCount += letterCount - 2;
                    }
                    i = j;
                    break;
                }

            }
        }
        return tripleCount;
    }

    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sum;
    }

    public String sameEnds(String string) {
        String longest = "";
        int j = 0;
        if (string.length() % 2 == 0) {
            j = string.length() / 2;
        } else {
            j = string.length() / 2 + 1;
        }
        for (int i = 0; j < string.length(); j++) {
            if (string.charAt(i) == string.charAt(j)) {
                longest += String.valueOf(string.charAt(i));
                i++;
            } else {
                longest = "";
            }
        }
        return longest;
    }

    public String mirrorEnds(String string) {
        int i = 0;
        int j = string.length() - 1;
        String image = "";
        while (i < string.length()) {
            if (string.charAt(i) == string.charAt(j)) {
                image += string.charAt(i);
                i++;
                j--;
            } else {
                return image;
            }
        }
        return image;
    }

    public int maxBlock(String str) {
        if (str.length() == 0) {
            return 0;
        }

        char lastChar = str.charAt(0);
        int count = 1;
        int lastCount = 0;

        for (int i = 1; i < str.length(); i++) {
            if (lastChar == str.charAt(i)) {
                count++;
            } else {
                lastChar = str.charAt(i);
                if (count > lastCount) {
                    lastCount = count;
                }
                count = 1;
            }
        }
        return Math.max(lastCount, count);
    }


}
