package Action6;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrazyCalcTest {

    CrazyCalc crazyCalc = new CrazyCalc();

    @Test
    public void positiveValueTest() {
        crazyCalc.operation(5);
        assertEquals(5, crazyCalc.get());
        crazyCalc.operation(15);
        assertEquals(15, crazyCalc.get());
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
        crazyCalc.operation(-15);
        crazyCalc.get();
    }
}