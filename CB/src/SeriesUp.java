import java.util.Arrays;

/**
 * Created by Stiv on 08/05/2017.
 */
public class SeriesUp {
    public static int[] seriesUp(int n) {
        final int initialN = n;
        final int length = n * (n + 1) / 2;
        n = 1;
        int i = 0;
        int[] array = new int[length];
        while (n <= initialN) {
            for (int j = 1; j <= n; j++) {
                array[i] = j;
                ++i;
            }
            ++n;
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(seriesUp(4)));
    }
}
