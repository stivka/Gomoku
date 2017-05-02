/**
 * Created by Stiv on 02/05/2017.
 */
public class CBArray1 {
    public int maxSpan(int[] nums) {
        int lastMax = 0;
        int maximumSpan = 0;
        boolean isSameNumber = false;

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] == nums[j]) {
                    isSameNumber = true;
                    maximumSpan = j - i + 1;
                    if (maximumSpan > lastMax) {
                        lastMax = maximumSpan;
                    }
                }
            }
        }
        if (!isSameNumber) {
            return 1;
        }
        return lastMax;
    }
    public static void main(String[] args) {
        CBArray1 instance = new CBArray1();
//        System.out.println(instance.maxSpan(new int[]{1, 2, 1, 1, 3}));
//        System.out.println(instance.maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
        System.out.println(instance.maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}));
    }
}
