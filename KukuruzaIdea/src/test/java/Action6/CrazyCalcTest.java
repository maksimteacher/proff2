package Action6;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrazyCalcTest {

    CrazyCalc crazyCalc = new CrazyCalc();

    @Test
    public void positiveValueTest() {
        int num = (int) (1 + 1000 * Math.random());
        crazyCalc.operation(num);
        assertEquals(num, crazyCalc.get());
    }

    @Test
    public void zeroValueTest() {
        crazyCalc.operation(0);
        assertEquals(0, crazyCalc.get());
    }

    @Test(expected = ArithmeticException.class)
    public void negativeValueTest() {
        crazyCalc.operation(-5);
        crazyCalc.get();

    }
}