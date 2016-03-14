package action03;

public class User {
	private String login;
	private String pass;
	private int countDays;
	private final static String separator = ";";
	
	public String toFileStream() {
		return login + separator + pass + separator + countDays +  "\n";
	}
	public static User fromFileStream(String str) {
		String[] arr = str.split(separator);
		try {
			return new User(arr[0], arr[1], Integer.parseInt(arr[2]));
		} catch (Exception e) {
		}
		return null;
	}
	public User(String login, String pass, int days) {
		super();
		this.login = login;
		this.pass = pass;
		this.countDays = days;
	}
	public User(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public int hashCode() {
		int codeLogin = 0;
		if(login!= null) codeLogin = login.hashCode();
		int codePass = 0;
		if(pass!= null) codePass = pass.hashCode();
		return codeLogin * 32 + codePass;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		User user = (User) obj;
		
		String separator = "_*_";
		String thisStr = login + separator + pass;
		String userStr = user.login + separator + user.pass;

		return thisStr.equals(userStr);
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", pass=" + pass + ", countDays=" + countDays + "]";
	}
	
	
	
}
