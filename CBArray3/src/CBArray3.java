/**
 * Created by Stiv on 02/05/2017.
 */
public class CBArray3 {
    public int[] fix45(int[] nums) {
        int[] valuesReplacedBy5 = new int[nums.length];
        int j = 0;

        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4 && nums[i + 1] != 5) {
                valuesReplacedBy5[j] = nums[i + 1];
                j++;
                nums[i + 1] = 5;
            }
        }
        j = 0;
        if (nums[0] == 5) {
            nums[0] = valuesReplacedBy5[j];
            j++;
            int k = 1;
        }
        int k = 0;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] == 5 && nums[i - 1] != 4) {
                nums[i] = valuesReplacedBy5[j];
                j++;
            }
        }
        return nums;
    }
}
