import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class QuadraticTest {
    @Test
    public void solve() {
        assertEquals(null, Quadratic.solve(1, 1, 1));
    }

    @Test
    public void testOrderofSolutions() {
        double[] x = Quadratic.solve(-1, 2, 3);
        assertEquals(-1, Math.min(x[0], x[1]), 0.001);
    }

    /* Unnecessary @Test
    public void testSolveCompareArrays() {
        assertTrue(Arrays.equals(Quadratic.solve(-1, 2, 3), new double[]{-1, 3}));
    }
*/

    @Test
    public void testSolveUsingMinMax() {
        double[] x = Quadratic.solve(-1, 2, 3);
        assertEquals(-1, Math.min(x[0], x[1]), 0.001);
        assertEquals(3, Math.max(x[0], x[1]), 0.001);
    }

    @Test
    public void testQuadraticCoefficientEqualsZero() {
        double[] x = Quadratic.solve(0,2,3);
        assertEquals(1, x.length);
        assertEquals(-1.5, x[0], 0.001);
    }
}