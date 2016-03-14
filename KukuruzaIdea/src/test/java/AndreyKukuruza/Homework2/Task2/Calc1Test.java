package AndreyKukuruza.Homework2.Task2;


import org.junit.Test;

import static org.junit.Assert.*;

public class Calc1Test {
    Calc1 calc;


    @Test
    public void testFirstNumber() throws Exception {
        calc = new Calc1("12+12=");
        assertEquals("FirstNumberTest", "24", calc.getResult());
        calc = new Calc1("012+12=");
        assertEquals("FirstNumberTest", "24", calc.getResult());
        calc = new Calc1("012*12=");
        assertEquals("FirstNumberTest", "144", calc.getResult());
        calc = new Calc1("00000120*12=");
        assertEquals("FirstNumberTest", "1440", calc.getResult());
    }

    @Test
    public void testOperation() throws Exception {
        calc = new Calc1("12*12=");
        assertEquals("OperationTest", "144", calc.getResult());
        calc = new Calc1("12/12=");
        assertEquals("OperationTest", "1", calc.getResult());
        calc = new Calc1("1-1=");
        assertEquals("OperationTest", "0", calc.getResult());
        calc = new Calc1("00000120/12=");
        assertEquals("OperationTest", "10", calc.getResult());
        calc = new Calc1("00000120/0=");
        assertEquals("OperationTest", Calculator.ByZero, calc.getResult());
    }

    @Test
    public void testSecondNumber() throws Exception {
        calc = new Calc1("12-12=");
        assertEquals("SecondNumberTest", "0", calc.getResult());
        calc = new Calc1("12+0012=");
        assertEquals("SecondNumberTest", "24", calc.getResult());
        calc = new Calc1("012*00012=");
        assertEquals("SecondNumberTest", "144", calc.getResult());
        calc = new Calc1("00000120*00012=");
        assertEquals("SecondNumberTest", "1440", calc.getResult());
    }

    @Test
    public void testResult() throws Exception {
        calc = new Calc1("12-12=");
        assertEquals("ResultTest", "0", calc.getResult());
        calc = new Calc1("12+0=");
        assertEquals("ResultTest", "12", calc.getResult());
        calc = new Calc1("012*00=");
        assertEquals("ResultTest", "0", calc.getResult());
        calc = new Calc1("00000120+00012=");
        assertEquals("ResultTest", "132", calc.getResult());
    }
}