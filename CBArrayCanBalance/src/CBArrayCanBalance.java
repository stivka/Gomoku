/**
 * Created by Stiv on 02/05/2017.
 */
public class CBArrayCanBalance {
    public boolean canBalance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int halfSum = sum / 2;
        if (sum % 2 == 1) {
            return false;
        }

        int trySum = 0;

        int i = 0;
        int j = nums.length - 1;

        int iSum = 0;
        int jSum = 0;

        if (nums.length == 1) {
            return false;
        }

        while (i <= j) {
            if (iSum > jSum && nums[j] >= 0) {
                jSum += nums[j];
                j--;

                // nothing changes, just continues.
            } else if (iSum <= jSum && nums[i] >= 0) { // if jSum is larger, or they are equal
                iSum += nums[i];
                i++;
            }
            else if (iSum > jSum && nums[i] < 0) {
                iSum += nums[i];
                i++;
            }
        }
        if (i > j) {
            if (jSum == iSum) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CBArrayCanBalance instance = new CBArrayCanBalance();
//        instance.canBalance(new int[]{1, 2, 3, 1, 0, 2, 3});
//        instance.canBalance(new int[]{1, 1, 1, 2, 1});
        instance.canBalance(new int[]{10, 0, 1, -1, 10});
    }
}
