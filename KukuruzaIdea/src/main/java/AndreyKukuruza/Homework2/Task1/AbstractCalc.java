package AndreyKukuruza.Homework2.Task1;

public abstract class AbstractCalc implements Calculator {
    private String result = "";
    private int temp;
    private char operation = '0';

    @Override
    public String printResult() {
        System.out.println("\nResult = " + result);
        return getResult();

    }

    public String getResult() {
        return result;
    }

    public AbstractCalc setResult(String result) {
        this.result = result;
        return this;
    }

    public int getTemp() {
        return temp;
    }

    public AbstractCalc setTemp(int temp) {
        this.temp = temp;
        return this;
    }

    public char getOperation() {
        return operation;
    }

    public AbstractCalc setOperation(char operation) {
        this.operation = operation;
        return this;
    }


}
