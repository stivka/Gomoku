/**
 * Created by Stiv on 09/05/2017.
 */
public class StrEqualIsNot {
    public static boolean equalIsNot(String str) {
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
    public static void main(String[] args) {
        StrEqualIsNot inst = new StrEqualIsNot();
        System.out.println(inst.equalIsNot("This is not"));
    }
}
