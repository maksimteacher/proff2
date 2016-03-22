package AndreyKukuruza.Homework2.Task1;

public class Calc extends AbstractCalc {
    String input;

    public Calc() {
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Calc(String input) {
        this.input = input;
        calculate();
    }

    public void calculate() {
        for (char p : input.toCharArray()) {
            System.out.println("Input " + p);
            inChar(p);
        }
    }

    @Override
    public void inChar(char p) {
        if (Character.isDigit(p))
            if (getOperation() == '0') {
                setResult(getResult() + p);
            } else {
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
                    if (Integer.parseInt(getResult()) == 0) {
                        setResult(BY_ZERO);
                        printResult();
                        return;
                    }
                    setResult(getTemp() / Integer.parseInt(getResult()) + "");
                    break;
            }
            printResult();
        }
    }
}