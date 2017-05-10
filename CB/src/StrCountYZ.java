/**
 * Created by Stiv on 09/05/2017.
 */
public class StrCountYZ {
    public static int countYZ(String str) {
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
    public static void main(String[] args) {
        StrCountYZ instance = new StrCountYZ();
//        System.out.println(instance.countYZ("fez day"));
        System.out.println(instance.countYZ("day:yak"));
    }
}
