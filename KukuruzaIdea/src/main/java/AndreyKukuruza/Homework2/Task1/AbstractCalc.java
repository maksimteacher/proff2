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


    public int getTemp() {
        return temp;
    }


    public char getOperation() {
        return operation;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }
}
