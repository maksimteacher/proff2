package calc;

public enum Command {
	ADD('+'), SUBSTRACT('-'), DIVIDE('/'), MULTIPLY('*');
	
	private char name;
	
	private Command(char str) {
		this.name = str;
	}
	
	public char getName() {
		return name;
	}
	
	public static Command getCommand(char c) {
		Command command = null;
		switch (c) {
		case '+' : command = ADD; break;
		case '-' : command = SUBSTRACT; break;
		case '/' : command = DIVIDE; break;
		case '*' : command = MULTIPLY;
		}
		return command;
	}
	
	public static String getDelimiter() {
		StringBuilder sb = new StringBuilder("[");
		for (Command c : Command.values()) {
			sb.append(c.name);
		}
		sb.append("]");
		System.out.println(sb);
		return sb.toString();
	}
	
	public String execute(int x, int y) {
		int res = 0;
		switch (this) {
		case ADD : res = x + y; break;
		case SUBSTRACT : res = x - y; break;
		case DIVIDE : {
			if (y == 0) {
				return "division by zero!";
			} else {
				res = x / y;
			}
			break;
		}
		case MULTIPLY : res = x * y;
		}
		return Integer.toString(res);
	}
}
