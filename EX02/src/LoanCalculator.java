import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Loan calculator for a fixed rate loan. Creates a payment schedule based on
 * user-inputted loan amount, interest rate percentage and loan period.
 */
public class LoanCalculator {

    /**
     * Constant.
     * Shortest allowed loan period in years.
     */
    public static final double MIN_LOAN_PERIOD = 1;

    /**
     * Constant.
     * Longest allowed loan period in years.
     */
    public static final double MAX_LOAN_PERIOD = 20;

    /**
     * Constant.
     * Smallest possible loan amount.
     */
    public static final double MIN_LOAN_AMOUNT = 1000;

    /**
     * Constant.
     * Largest possible loan amount.
     */
    public static final double MAX_LOAN_AMOUNT = 10000;

    /**
     * Constant.
     * Smallest possible yearly interest rate.
     */
    public static final double MIN_INTEREST_RATE = 0;

    /**
     * Constant.
     * Largest possible yearly interest rate.
     */
    public static final double MAX_INTEREST_RATE = 100;

    /**
     * Total width of the output table.
     */
    public static final int TABLE_WIDTH = 55;

    /**
     * Number of months in one year.
     */
    public static final int MONTHS_IN_YEAR = 12;

    /**
     * Determine whether the given loan amount is in the range
     * 1000 to 10 000 (inclusive)
     *
     * @param amount Loan amount to be checked.
     * @return True if the loan amount is in the allowed range,
     * false otherwise.
     */
    public static boolean isValidLoanAmount(double amount) {
        if (amount >= MIN_LOAN_AMOUNT && amount <= MAX_LOAN_AMOUNT) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether the given yearly interest rate is in the range 1 to 100 (inclusive).
     *
     * @param yearlyRate Interest rate to be checked.
     * @return True if the interest rate is in the allowed range, false otherwise.
     */
    public static boolean isValidInterestRate(double yearlyRate) {
        if (yearlyRate >= MIN_INTEREST_RATE && yearlyRate <= MAX_INTEREST_RATE) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether the given loan period is in the range 1 to 20 (inclusive).
     * Only whole years are allowed, for example 2.5 is not a valid number.
     *
     * @param years Length of the period in years
     * @return True if the length of the period is in the allowed range, false otherwise.
     */
    public static boolean isValidLoanPeriod(double years) {
        if (years >= MIN_LOAN_PERIOD && years <= MAX_LOAN_PERIOD) {
            return true;
        }
        return false;
    }

    /**
     * Repeats given string s count time.
     * In case the string cannot be repeated,
     * the result should be empty string.
     *
     * @param s String to be repeated.
     * @param count How many times the string will be repeated.
     * @return Repeated string.
     */
    public static String repeat(String s, int count) {
        if (s.equals(null) || count < 1) {
        return null;
        }
        for (int i = 1; i <= count; i++) {
            s += s;
        }
        return s;

    /**
     * Return the current date and time.
     * Do not change this method. See also:
     * https://ained.ttu.ee/javadoc/DateTime.html
     *
     * @return the current date and time as a calendar.
     */
    public static YearMonth currentDate() {
        return YearMonth.now();
    }

    /**
     * Add one month to the date given in the calendar.
     *
     * Do not change this method.
     * See also: https://ained.ttu.ee/javadoc/DateTime.html
     *
     * @param currentDate The date to be updated.
     */
    public static YearMonth nextMonth(YearMonth currentDate) {
        if (currentDate != null) {
            return currentDate.plusMonths(1);
        } else {
            return null;
        }
    }

    /**
     * Format the calendar as "MM.yyyy", where MM and yyyy are the
     * month and year set in the calendar.
     * For example, a calendar representing a date in February 2017
     * is formatted as "02.2017". Null input returns "##.####".
     *
     * Do not change this method.
     * See also: https://ained.ttu.ee/javadoc/DateTime.html
     *
     * @param date The date to be converted.
     * @return The formatted date.
     */
    public static String monthAndYearStringFrom(YearMonth date) {
        if (date == null) {
            return "##.####";
        } else {
            return date.format(DateTimeFormatter.ofPattern("MM.yyyy"));
        }
    }

    /**
     * Print a separator line for the table.
     */
    public static void printSeparator() {
        // Your code here
    }

    /**
     * Calculate and print out the payment plan for a fixed rate loan.
     *
     * In the case of a fixed rate loan, the loan amount is divided into
     * equal parts which are paid back monthly. In addition to the fixed
     * monthly amount, extra money must be paid as interest.
     *
     * The interest payment for a given month depends on the
     * monthly interest percentage (rate / 100 / 12) and the amount left to pay:
     *
     *     IP = interest percent * amount
     *
     * The payment plan must also give an overview of how much money was
     * spent on interest payments and how much was paid back in total.
     * All amounts should be rounded to 2 decimal points.
     *
     * The first payment is made on the next month, i.e. if today is February,
     * the first date in the table should be March.
     *
     * A table is formatted like this (without the three dots, of course):
     *
     * Date    To pay   Main payment Interest payment Total
     * -------------------------------------------------------
     * 03.2017  1000.00        83.33             0.83    84.69
     * 04.2017   916.67        83.33             0.76    84.10
     * ...
     * 02.2018    83.33        83.33             0.07    83.40
     * -------------------------------------------------------
     *           Total:      1000.00             5.42  1005.42
     *
     * Each column is wide enough to contain the largest possible value
     * inside it and its header label (7-8-12-16-8). Columns are separated
     * by a single space.
     *
     * Hint: Examine the printTopRow() method below.
     *
     * Useful information about string formatting:
     * https://examples.javacodegeeks.com/core-java/lang/string/java-string-format-example/
     *
     * @param loanAmount Size of the loan amount.
     * @param period Period of the loan in years.
     * @param interestRate Fixed yearly interest rate percent.
     */
    public static void printFixedPaymentPlan(
            double loanAmount, double period, double yearlyInterestRate) {
        // Your code here
    }

    /**
     * Print the top row of the table.
     */
    public static void printTopRow() {
        System.out.printf("%-7s %-8s %-12s %-16s %-8s\n",
                "Date", "To pay", "Main payment", "Interest payment", "Total");
    }

    /**
     * Print one data row of the table.
     *
     * @param currentDate Date which the row represents.
     * @param amountLeft Amount left to pay by that month.
     * @param monthlyPayment Main part of the payment to be made that month.
     * @param interestPayment
     */
    public static void printRow(
            YearMonth currentDate, double amountLeft, double monthlyPayment, double interestPayment) {
        // Your code here

    }
    /**
     * Print the bottom row of the table.
     *
     * @param loanAmount
     * @param interestCost
     */
    public static void printBottomRow(double loanAmount, double interestCost) {
        // Your code here
    }

    /**
     * Entry point of the program.
     * Ask user for the necessary inputs and print the corresponding payment schedule.
     * When an input is invalid (too big/too small or makes no sense), ask for the
     * same value again until proper input is provided, then move on to the next input.
     *
     * Use the following order for asking: amount - period - interest.
     *
     * @param args Arguments from the command line.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Your code here
    }
}