/**
 * Created by Stiv on 02/05/2017.
 */
public class CBArray2 {
    public int[] fix34(int[] nums) {
        int[] valuesReplacedBy4 = new int[nums.length];
        int j = 0;
        int count3 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                valuesReplacedBy4[j] = nums[i + 1];
                j++;
                nums[i + 1] = 4;
            }
        }
        j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4 && nums[i - 1] != 3) {
                nums[i] = valuesReplacedBy4[j];
                j++;
            }

        }
        return nums;
    }
}
