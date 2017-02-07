/**
 *
 */
public class MonthlyPayment {
    /**
     *
     */
    public static int perCENT = 100;
    /**
     *
     */
    private static int monthsYEAR = 12;

    /**
     * Entry point of the program.
     * @param args Arguments from command line.
     */
    public static void main(String[] args) {
        System.out.println(getMonthlyPaymentString(1200.00, 1, 1, 0)); // => Monthly payment is: 101.00 euros.
        System.out.println(getMonthlyPaymentString(150000, 25, 2.6, 15000)); // => Monthly payment is: 461.70 euros.
        System.out.println(getMonthlyPaymentString(250000, 30, 3.5, 18000)); // => Monthly payment is: 667.00 euros.
        System.out.println(getMonthlyPaymentString(250000, -1, 1, 10000)); // => Invalid loan criteria!
    }

    /**
     * Method that returns the monthly payment as a string.
     *
     * Use the result of getMonthlyPayment to determine
     * which String to return. The check for invalid values
     * should be done in getMonthlyPayment. No point to
     * check values in both methods.
     *
     * @param loanAmount Amount of the loan.
     * @param loanLength Length of the loan in years.
     * @param interestRate Interest rate.
     * @param downPayment Down payment amount.
     * @return Monthly payment as a string.
     */
    public static String getMonthlyPaymentString(double loanAmount, int loanLength, double interestRate, double downPayment) {
        if (Double.isNaN(getMonthlyPayment(loanAmount, loanLength, interestRate, downPayment))) {
            return ("Invalid loan criteria!");
        }
        return ("Monthly payment is: " + Double.toString(getMonthlyPayment(loanAmount, loanLength, interestRate, downPayment))
                    + " euros.");
    }

    /**
     * Method that calculates the monthly payment amount.
     *
     * This method should validate the given values:
     * loanAmount, loanLength, interestRate > 0,
     * downPayment >= 0.0.
     * In case the values are invalid, the method returns Double.NaN.
     *
     * @param loanAmount Amount of the loan.
     * @param loanLength Length of the loan in years.
     * @param interestRate Interest rate.
     * @param downPayment Down payment amount.
     * @return Monthly payment amount. In case the arguments are invalid, returns Double.NaN.
     * In case the down payment is enough to cover the loan, returns 0.
     */
    public static double getMonthlyPayment(double loanAmount, int loanLength, double interestRate, double downPayment) {
        double monthlyPayment;
        if (Double.isNaN(loanAmount) || Double.isNaN(loanLength) || Double.isNaN(interestRate)
                || Double.isNaN(downPayment)) {
            return Double.NaN;
            // check for value 'not a number', does this even do anything and is there need for null check?
        }
        if (!(loanAmount > 0) || (loanLength < 1) || !(interestRate > 0) || !(downPayment >= 0)) {
            return Double.NaN;
        }
        monthlyPayment = ((loanAmount * (1 + (interestRate / perCENT)))); // amount the bank will receive ultimately.
        monthlyPayment -= downPayment; // subtracts the down payment.
        if (!(monthlyPayment > 0)) {
            return 0; // if the down payment is larger than the sum left to pay, nothing is left to pay.
        // remains however question whether the bank should pay anything back. In other words, can the downpayment
            // even be larger than the payment?
        }
        monthlyPayment /= (loanLength * monthsYEAR);
        // the sum with the interest, minus the down payment, is divided by the amount of months to determine the
        // monthly payment.
        return (double) Math.round(monthlyPayment * 100000d) / 100000d;
    }
}
