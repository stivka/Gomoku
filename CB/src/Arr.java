/**
 * Created by Stiv on 02/05/2017.
 */
public class Arr {
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
    public boolean linearIn(int[] outer, int[] inner) {
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
    public int[] squareUp(int n) {
        if (n == 0) {
            return new int[0];
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
    public int[] seriesUp(int n) {
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
}
