/**
 * Created by Stiv on 03/05/2017.
 */
public class EX12 {
    public static int find(String where, String what) {

        if (what.equals("")) {
            return 0;
        }
        if (where.length() == 0) {
            return 0;
        }
        if (what.equals(where.substring(0, what.length()))) {
            return 0;

        } else {
            return 1 + find(where.substring(1), what);
        }

    }

    public static int findaway(String where, String what) {
        if (where.length() == 0) {
            where = what;
            return - 1;
        }

        if (what.equals(where.substring(0, what.length()))) {

        }
        return findaway(where + what, what)
    }
    public static void main(String[] args) {
        System.out.println(find("tere", "e"));
        System.out.println(find("tere", "a"));
        System.out.println(find("abcde", "cde"));
//        String what = "cde";
//        String where = "abcde";
//        System.out.println(where.indexOf(what));
        // begin index inclusive till ending index exclusive.
//        System.out.println(("abcde").substring(2, 2 + what.length()));
    }
}
