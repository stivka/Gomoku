/**
 * Created by Stiv on 02/05/2017.
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



}
