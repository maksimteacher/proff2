package injection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControllerDB extends HttpServlet {

	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/new_schema";
	private static String login = "root";
	private static String pass = "root123";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		StringBuilder sb = new StringBuilder("<center>");
		String formuser = request.getParameter("login");
		String formpass = request.getParameter("pass");

		String query = "select * from users where user='" + formuser + "' and pass = '" + formpass + "'";
		sb.append("<table border=1><tr><td><h2>" + query + "</table><br><br><br><br><br><br><br><br><h1>");
		Connection connect = null;
		try {
			try {
				Class.forName(nameDriver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				sb.append("Добро пожаловать на сайт, " + rs.getString(4) + ", напоминаем, что Ваш баланс: $" + rs.getString(5) + ".<br><br>");
				sb.append("Нажмите <a href=http://google.com/search?ie=UTF-8&hl=ru&q=" + rs.getString(1) + ">тут</a>, если ваш браузер не поддерживает переадресацию.");
			}
			else{
				sb.append("<font color=red>Ваши логин и пароль не распознаны, проверьте правильность ввода.");
			}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(sb.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
}
