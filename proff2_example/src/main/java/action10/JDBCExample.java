package action10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/proff2";
	private static String login = "root";
	private static String pass = "root";

	public static void main(String[] args) {
		try {
			Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String query = "select * from orders";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, login, pass);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2) + ", ");
				if (rs.getObject(3) == null)
					System.out.print("null0,");
				else
					System.out.print(rs.getInt(3) + ", ");
				System.out.print(rs.getString(4) + ", ");
				System.out.print(rs.getString(5) + ", ");
				System.out.println();
			}
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
