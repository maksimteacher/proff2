package jdbc;

import java.sql.*;

public class MyJDBC {
	private static String nameDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/firm";
	private static String login = "root";
	private static String password = "root";
	

	public static void main(String[] args) {
		
		try {
			Class c = Class.forName(nameDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connect = null;
		String query = "SELECT * FROM orders";
		
		try {
			connect = DriverManager.getConnection(url, login, password);
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2) + ", ");
				if(rs.getString(3) == null) {
					System.out.print("null, ");
				} else 
					System.out.print(rs.getString(3) + ", ");
				System.out.print(rs.getString(4) + ", ");
				System.out.print(rs.getString(5) + ", ");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
