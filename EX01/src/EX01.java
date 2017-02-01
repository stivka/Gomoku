/**
 * Created by Stiv on 01/02/2017.
 */
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

    public class EX01 {

        /**
         * Repeats given string s count time.
         *
         * @param s     String to be repeated.
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
         * <p>
         * The line will be in format:
         * +-------+
         *
         * @param width The total width of the line.
         * @return Separator line.
         */
        public static String getLineSeparator(int width) {
        }


        public static String getFormattedLine(String line, int length) {
        }


        /**
         * Return a string where given text is in center.
         *
         * @param text  Text to be centered.
         * @param width With of the outcome.
         * @return New string where text is padded with spaces so
         * that the text is centered.
         */
        public static String getStringInCenter(String text, int width) {
        }

        /**
         * Generates a formatted table.
         * <p>
         * +-------+
         * |  head |
         * +-------+
         * | text  |
         * +-------+
         * <p>
         * Every line has a new line character ("\n") in the end.
         *
         * @param heading Heading text, to be centered.
         * @param content Content text, to be formatted.
         * @param width   Width of the table.
         * @return Formatted table.
         */
        public static String getTable(String heading, String content, int width) {

        }

        public static void main(String[] args) {

        }
    }
}