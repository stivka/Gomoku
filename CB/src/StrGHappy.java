/**
 * Created by Stiv on 09/05/2017.
 */
public class StrGHappy {
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
    public static void main(String[] args) {
        StrGHappy instance = new StrGHappy();
        System.out.println(instance.gHappy("xxggxx"));
        System.out.println(instance.gHappy("xxggyygxx"));
        System.out.println(instance.gHappy("xxgggxyg"));
    }
}
