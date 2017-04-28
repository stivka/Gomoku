import java.util.Arrays;

/**
 * Created by Stiv on 28/04/2017.
 */
public class TK2 {
    public static int[] zeroFront(int[] nums) {
        int zeroCount = 0;
        int[] sortedNums = new int[nums.length];
        int lastIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sortedNums[zeroCount] = nums[i];
            }
        }

        System.out.println(Arrays.toString(sortedNums));
        return sortedNums;
    }
    public static void main(String[] args) {
        zeroFront(new int[]{2, 0, 1, 2});
        zeroFront(new int[]{1, 0, 0, 1});
        zeroFront(new int[] {0, 1, 1, 0, 1});
        zeroFront(new int[]{1, 0});
        zeroFront(new int[]{2, 1, 0, 1, 2});
        zeroFront(new int[]{-1, 0});
    }
}
