import java.util.Arrays;
/**
 * Quadratic equation solver.
 */
public class Quadratic {
    /**
     * Finds the solutions for quadratic equation.
     *
     * ax^2 + bx + c = 0
     *
     * The method should also handle the case where
     * square (quadratic) component is zero, e.g.
     * 3x = 3.
     * @param a Square component.
     * @param b Linear component.
     * @param c Constant.
     * @return Array of solutions. In case of 2 solutions, the order is not important.
     * In case there are no solutions, returns null.
     */
    public static double[] solve(double a, double b, double c) {
        // TODO: a == 0
        double d = b * b - 4 * a * c; // This is the part under the square root.
        if (d > 0) {
            return new double[]{(-b + Math.sqrt(d)) / 2 / a, (-b - Math.sqrt(d)) / 2 / a};
        } else if (d == 0) {
            return new double[]{-b / 2 / a};
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("-x^2 + 2x + 3 = 0");
        System.out.println(Arrays.toString(solve(-1, 2, 3)));
    }
}
