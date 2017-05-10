/**
 * Created by Stiv on 04/05/2017.
 */
public class LinearIn {
    public static boolean linearIn(int[] outer, int[] inner) {
        if (inner.length == 0) {
            return true;
        }
        for (int i = 0; i < inner.length; i++) {
            for (int j = 0; j < outer.length; j++) {
                if (inner[i] < outer[j]) {
                    return false;
                }
                if (inner[i] == outer[j]) {
                    if (i == inner.length - 1) {
                        return true;
                    } else {
                        j = i;
                        break;
                    }
                }

            }
        }
        return false;
    }
    public static void main(String[] args) {
        LinearIn instance = new LinearIn();
        System.out.println(linearIn(new int[]{0, 3, 4, 5}, new int[]{0, 5}));
    }
}
