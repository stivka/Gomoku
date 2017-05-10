import java.util.Arrays;

/**
 * Created by Stiv on 07/05/2017.
 */
public class ArrSquareUp {
    public static int[] squareUp(int n) {
        if (n == 0) {
            return new int[] {0};
        }
        if (n == 1) {
            return new int[]{1};
        }
        int[] array = new int[n * n];
        int initialN = n;
        int nextN = n;
        int o = 1;

        for (int i = (n * n - 1); i > -1; i--) {
            if ((i + 1) % n == 0) {
                for (int j = 1; j < n + 1; j++) {
                    if (j < nextN) {
                        array[i - (j - 1)] = j;
                    }
                    if (j == nextN) {
                        array[i - (j - 1)] = j;
                        --nextN;
                        break;
                    }
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        ArrSquareUp instance = new ArrSquareUp();
        System.out.println(Arrays.toString(squareUp(3)));
    }
}
