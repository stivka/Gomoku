import static java.lang.System.in;

/**
 * Created by Stiv on 09/05/2017.
 */
public class Recursion {
    public boolean array6(int[] nums, int index) {
        if (index == nums.length) {
            return false;
        }
        if (nums[index] == 6) {
            return true;
        }
        return array6(nums, index + 1);
    }

    public static void main(String[] args) {
        Recursion rec = new Recursion();
        System.out.println(rec.array6(new int[]{1, 6, 4}, 0));
    }
}

