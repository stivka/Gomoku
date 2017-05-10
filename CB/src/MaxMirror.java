/**
 * Created by Stiv on 08/05/2017.
 */
public class MaxMirror {
    public static int maxMirror(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int c = nums.length - 1;
        boolean restart = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[c] == nums[i]) {
                ++max1;
                for (int j = 1; j < nums.length; j++) {
                    if (c - j >= 0 && i + j < nums.length) {
                        if (nums[c - j] == nums[i + j]) {
                            ++max1;
                        } else {
                            if (max1 > max2) {
                                max2 = max1;
                                max1 = 0;
                            }
                            c = c - j;
                            i = i + j - 1;
                            break;
                        }

                    } else {
                        i = -1;
                        --c;
                        break;
                    }
                }
            }
            if (i == nums.length - 1 && c > 0) {
                i = 0;
                --c;
            }
        }
        return max2;
    }
    public static void main(String[] args) {
//        System.out.println(maxMirror(new int[]{1, 2, 4, 5, 2, 1}));
//        System.out.println(maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
        System.out.println(maxMirror(new int[]{1, 2, 1, 4}));
    }
}
