/**
 *
 * Table generator.
 */
public class TableGenerator {

    /**
     * Repeats given string s count time.
     *
     * Use this method in getLineSeparator()
     * and getStringInCenter().
     * If you solve the mentioned methods
     * without using this method, you still have to
     * implement this one.
     * In case the string cannot be repeated,
     * the result should be empty string.
     *
     * @param s String to be repeated.
     * @param count How many times the string will be repeated.
     * @return Repeated string.
     */
    public static String repeat(String s, int count) {
        for (int i = 0; i < count; i++) {
            s += s;
        }
        return s;
    }

    /**
     * Generate a separator line for table.
     *
     * The line will be in format (length = 9):
     * +-------+
     * The minimal separator (whatever the width value):
     * ++
     *
     * @param width The total width of the line.
     * @return Separator line.
     */
    public static String getLineSeparator(int width) {
        String sep = "";
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                sep += "+";
            } else {
                sep += "-";
            }
        }
        return sep;
    }


    /**
     * Align text to right (padding with spaces).
     *
     * This method is for the text only, no borders should be added.
     * "abc", 6 => "   abc"
     * If the text is too long, then the last part which fits into the
     * width should be used:
     * "abcdf", 3 => "cdf"
     *
     * The result should be a string of required length,
     * or "" if the length is negative.
     *
     * @param line Text to be aligned.
     * @param length The length of the output
     * @return Text aligned right.
     */
    public static String getStringAlignedRight(String line, int length) {
        String other = "";
        if (length < 1) {
            return "";
        }
        if (line.equals(null)) {
            for (int i = 0; i < length; i++) {
                other += " ";
            }
            return other;
        }
        for (int i = line.length() - length; i < line.length(); i++) {
            // if the 'cursor' is at the negative side of the line it lays spaces, once it reaches the positive side
            // it will lay down as much of the line that is left.
            if (i < 0) {
                other += " ";
            } else {
                other += line.charAt(i);
            }
            if (line.equals(null)) {
                other += " ";
            }
        }
    return other;
    }



    /**
     * Return a string where given text is in center.
     *
     * "a", 3 => " a "
     *
     * If the text doesn't fit exactly, then
     * the right left pad should be one space longer
     * than the left pad:
     * "ab", 5 => "  ab "
     *
     * If the width is smaller than the length of the text,
     * center part of the text should be returned.
     * "abcd", 2 => "bc"
     * In case the center part doesn't "fit" exactly,
     * then start from the smaller position:
     * "abcde", 2 => "bc"
     * (either "bc" or "cd", but
     * use the earlier substring)
     *
     * The result should be a string of required length,
     * or "" if the length is negative.
     *
     * @param text Text to be centered.
     * @param width With of the outcome.
     * @return New string where text is padded with spaces so
     * that the text is centered.
     */
    public static String getStringInCenter(String text, int width) {
        String lp = ""; // left padding
        String rp = ""; // right padding
        int ls = 0;
        int rs = 0;
        int cc = 0;
        int fc = 0;
        int lc = 0;
        int lo = 0;
        if (width < 1) {
            return "";
        }
        if (text.equals(null)) {
            for (int i = 0; i < text.length(); i++) {
                lp += " ";
            }
            return lp;
        }

        if (text.length() - width > -1) { // if no padding is required.
            cc = (text.length() - 1) / 2; // finds the center character position, or center-left character position.
            fc = cc - ((width - 1) / 2); // finds the first character.
            lc = cc + width - 1;
            return text.substring(fc, lc);
//          return text.substring((((text.length() - 1) / 2) - ((width - 1) / 2)), ((((text.length() - 1) / 2)
//          - ((width - 1) / 2) + width)));
        } // if there's width left over for the edges.
        lo = width - text.length(); // leftover
        ls = ((lo + 1) / 2);
        rs = lo - ls;
        for (int l = 1; l <= ls; l++) {
            lp += " ";
        }
        for (int r = 1; r <= rs; r++) {
            rp += " ";
        }
        return lp + text + rp;
    }


        /**
         * Generates a formatted table.
         *
         * +-------+
         * |  head |
         * +-------+
         * |   text|
         * +-------+
         *
         * The first cell is heading and the text is centered
         * (use getStringInCenter() method).
         * The second cell is the contents and the text is aligned right
         * (use getStringAlignedRight() method).
         * Every line has a new line character ("\n") in the end.
         * No matter what the input is, the output should have 6 rows.
         * All the previous methods (which you should use here)
         * should take care of different "bad" arguments.
         * The minimal result can be:
         * ++
         * ||
         * ++
         * ||
         * ++
         *
         * @param heading Heading text, to be centered.
         * @param content Content text, to be formatted.
         * @param width Width of the table.
         * @return Formatted table.
         */

    public static String getTable(String heading, String content, int width) {
        if (width < 2) {
            width = 2;
        }
        return (getLineSeparator(width) + "\n" + "|" + getStringInCenter(heading, width - 2) + "|" + "\n"
                + getLineSeparator(width) + "\n" + "|" + getStringAlignedRight(content, width - 2) + "|" + "\n"
                + getLineSeparator(width) + "\n");
    }

    /**
     *
     * @param args is the server input
     */
    public static void main(String[] args) {
        System.out.println(getLineSeparator(10));
        System.out.println("+--------+");

        System.out.println(getStringAlignedRight("tere", 10));
        System.out.println("      tere");

        System.out.println("|" + getStringInCenter("tere", 3) + "|");
        System.out.println("|ter|");

        String table = getTable("Title", "Some text", 20);
        System.out.println(table);
        /*
+------------------+
|       Title      |
+------------------+
|         Some text|
+------------------+

         */

        table = getTable("hi", "long text here", 10);
        System.out.println(table);
        /*
+--------+
|   hi   |
+--------+
|ext here|
+--------+

         */


    }
}
