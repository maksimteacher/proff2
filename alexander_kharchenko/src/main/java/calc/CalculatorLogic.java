package calc;

import java.util.StringTokenizer;
import java.util.regex.Matcher;

public class CalculatorLogic {

	public static String parse(String str) {
		
		String[] params = str.split(Command.getDelimiter());
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		char com = str.charAt(params[0].length());
		System.out.println(x);
		System.out.println(y);
		System.out.println(com);
		Command command = Command.getCommand(com);
		System.out.println(command);
		String result;
		result = command.execute(x, y);
		return result;
	}
	
	public static boolean foo(String str) {
		return str.matches("[0-9]+" + Command.getDelimiter() + "[0-9]+");
	}
}
