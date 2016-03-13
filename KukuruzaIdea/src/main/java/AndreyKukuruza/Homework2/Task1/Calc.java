package AndreyKukuruza.Homework2.Task1;

import java.util.IntSummaryStatistics;

public class Calc extends AbstractCalc {
    @Override
    public void inChar(char p) {
        if (Character.isDigit(p) && getOperation() == '0') {
            setResult(getResult() + p);
        }
        if (Character.isDigit(p) && getOperation() != '0') {
            if (getTemp() == 0) {
                setTemp(Integer.parseInt(getResult()));
                setResult(p + "");
                return;
            }
            setResult(getResult() + p);
        }
        if (p == '-' || p == '+' || p == '*' || p == '/') {
            setOperation(p);
        }
        if (p == '=') {
            switch (getOperation()) {
                case '+':
                    setResult(getTemp() + Integer.parseInt(getResult()) + "");
                    break;
                case '-':
                    setResult(getTemp() - Integer.parseInt(getResult()) + "");
                    break;
                case '*':
                    setResult(getTemp() * Integer.parseInt(getResult()) + "");
                    break;
                case '/':
                    setResult(getTemp() / Integer.parseInt(getResult()) + "");
                    break;
            }
            printResult();
        }
    }
}