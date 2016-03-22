package action04;

public class WholeNCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public interface Calculator{
		 public final String ByZero = "Error";
		 public String printResult();
		 public String getResult();
		 public void inChar(char p);
		}
		public class AbstractCalc implements Calculator{
		 private String result;
		 private int temp;
		 private char operation;
		 @Override
		 public String printResult(){
		  System.out.println("Result = " + result);
		 }
		 public String getResult(){
		  return result;
		 }
		}
}
