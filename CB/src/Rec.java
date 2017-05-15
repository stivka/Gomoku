/**
 * Created by Stiv on 02/05/2017.
 * 25 Codingbat recursion exercises.
 */
public class Rec {
    public int factorial(int n) {
        if (n == 1) return 1;

        return n * factorial(n - 1);

    }

    public int bunnyEars(int bunnies) {

        if (bunnies == 0) return 0;


        return 2 + bunnyEars(bunnies - 1);
    }

    public int fibonacci(int n) {
        if (n == 0) return n;
        if (n == 1) return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        if (bunnies == 1) {
            return 2;
        }
        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        }
        return 2 + bunnyEars2(bunnies - 1);
    }

    public int triangle(int rows) {
        if (rows == 0) {
            return 0;
        }
        if (rows == 1) {
            return 1;
        }
        else {
            return rows + triangle(rows - 1);
        }
    }

    public int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    public int count7(int n) {
        if (n > 0) {
            int count = 0;
            if (n % 10 == 7) {
                count++;
                return count + count7(n / 10);
            }
            else return count + count7(n / 10);
        }
        return 0;
    }

    public int count8(int n) {
        if (n > 0) {
            int count = 0;
            if (n % 10 == 8) {
                count++;
                if ((n / 10) % 10 == 8) {
                    count++;
                }
                return count + count8(n / 10);
            }
            else return count + count8(n / 10);
        }
        return 0;
    }

    public int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        }
        return base * powerN(base, n - 1);
    }

    public int countX(String str) {
        int count = 0;
        if (str.length() == 0) {
            return 0;
        }
        if (str.charAt(0) == 'x') {
            count++;
        }
        if (str.length() == 1) {
            return count;
        }
        return count + countX(str.substring(1));
    }

    public int countHi(String str) {
        int count = 0;
        if (str.length() <= 2) {
            if (str.equals("hi")) {
                return ++count;
            }
            return 0;
        }
        if (str.substring(0,2).equals("hi")) {
            count++;
        }
        // count += countHi(str);
        return count + countHi(str.substring(1,str.length()));
    }

    public String changeXY(String str) {
        String change = "";
        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return "y" + changeXY(str.substring(1, str.length()));
        } else {
            return str.charAt(0) + changeXY(str.substring(1, str.length()));
        }
    }

    public String changePi(String str) {
        if (str.length() == 0) {
            return "";
        }

        if (str.length() >= 2) {
            if (str.substring(0, 2).equals("pi")) {
                return "3.14" + changePi(str.substring(2, str.length()));
            }
        }
        return str.charAt(0) + changePi(str.substring(1, str.length()));
    }

    public String noX(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return noX(str.substring(1));
        }
        return str.charAt(0) + noX(str.substring(1));
    }

    public boolean array6(int[] nums, int index) {
        if (index == nums.length) {
            return false;
        }
        if (nums[index] == 6) {
            return true;
        }
        return array6(nums, index + 1);
    }

    public int array11(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (index >= nums.length) {
            return 0;
        }
        if (nums[index] == 11) {
            return 1 + array11(nums, index + 1);
        }
        return 0 + array11(nums, index + 1);
    }

    public boolean array220(int[] nums, int index) {
        if (nums.length == 0) {
            return false;
        }
        if (index >= nums.length) {
            return false;
        }
        if (index + 1 >= nums.length) {
            return false;
        }
        if (nums[index] * 10 == nums[index + 1]) {
            return true;
        }
        return array220(nums, index + 1);
    }

    public String allStar(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return String.valueOf(str.charAt(0));
        }
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    public String pairStar(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        }
        return str.charAt(0) + pairStar(str.substring(1));
    }

    public String endX(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return endX(str.substring(1)) + "x";
        }
        return str.charAt(0) + endX(str.substring(1));
    }

    public int countPairs(String str) {
        if (str.length() < 3) {
            return 0;
        }
        if (str.charAt(0) == str.charAt(2)) {
            return 1 + countPairs(str.substring(1));
        }
        return 0 + countPairs(str.substring(1));
    }

    public int countAbc(String str) {
        if (str.length() < 3) {
            return 0;
        }
        if (str.charAt(0) == 'a' && str.charAt(1) == 'b' && (str.charAt(2) == 'c' ||
                str.charAt(2) == 'a')) {
            return 1 + countAbc(str.substring(1));
        }
        return 0 + countAbc(str.substring(1));
    }

    public int count11(String str) {
        if (str.length() < 2) {
            return 0;
        }

        if (str.charAt(0) == '1' && str.charAt(1) == '1') {
            return 1 + count11(str.substring(2));
        }
        return 0 + count11(str.substring(1));

    }

    public String stringClean(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return stringClean(str.substring(1));
        }
        return str.charAt(0) + stringClean(str.substring(1));
    }

    public int countHi2(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.length() == 2 && str.charAt(0) == 'h' && str.charAt(1) == 'i') {
            return 1;
        }
        if (str.length() >= 3) {
            if (str.charAt(0) == 'x' && str.charAt(1) == 'h' && str.charAt(2) == 'i') {
                if (str.length() >= 4) {
                    return 0 + countHi2(str.substring(3));
                }
                return 0;
            }
            if (str.charAt(0) == 'h' && str.charAt(1) == 'i') {
                return 1 + countHi2(str.substring(2));
            }
        }
        return 0 + countHi2(str.substring(1));
    }
}
