import org.junit.Test;
import static org.junit.Assert.*;

public class RationalTest {

    // Test for Scenario 1: Reduction
    @Test
    public void testReduction() {
        assertEquals(new Rational(1, 1), new Rational(4, 4));
        assertEquals(new Rational(1, 2), new Rational(30, 60));
        assertEquals(new Rational(3, 2), new Rational(12, 8));
        assertEquals(new Rational(1, 2), new Rational(2, 4));
    }

    // Test for Scenario 2: Addition
    @Test
    public void testAddition() {
        assertEquals(new Rational(7, 6), new Rational(1, 2).add(new Rational(2, 3)));
        assertEquals(new Rational(5, 6), new Rational(1, 3).add(new Rational(1, 2)));
    }

    // Test for Scenario 3: Subtraction
    @Test
    public void testSubtraction() {
        assertEquals(new Rational(-1, 6), new Rational(1, 2).subtract(new Rational(2, 3)));
        assertEquals(new Rational(1, 6), new Rational(1, 2).subtract(new Rational(1, 3)));
    }

    // Test for Scenario 4: Multiplication
    @Test
    public void testMultiplication() {
        assertEquals(new Rational(1, 3), new Rational(1, 2).multiply(new Rational(2, 3)));
        assertEquals(new Rational(1, 4), new Rational(1, 2).multiply(new Rational(1, 2)));
    }

    // Test for Scenario 5: Division
    @Test
    public void testDivision() {
        assertEquals(new Rational(3, 4), new Rational(1, 2).divide(new Rational(2, 3)));
        assertEquals(new Rational(2, 1), new Rational(1, 2).divide(new Rational(1, 4)));
    }

    // Test for Scenario 6: Absolute Value
    @Test
    public void testAbsoluteValue() {
        assertEquals(new Rational(1, 2), new Rational(1, 2).abs());
        assertEquals(new Rational(1, 2), new Rational(-1, 2).abs());
        assertEquals(new Rational(1, 2), new Rational(1, -2).abs());
        assertEquals(new Rational(1, 2), new Rational(-1, -2).abs());
    }

    // Test for Scenario 7: Power
    @Test
    public void testPower() {
        assertEquals(new Rational(1, 8), new Rational(1, 2).pow(3));
        assertEquals(new Rational(8, 1), new Rational(1, 2).pow(-3));
        assertEquals(new Rational(1, 1), new Rational(2, 3).pow(0));
    }
}
