package kr.or.ddit.study06.sec05.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn = null;

	public static Connection getConnection() {

		String url = "jdbc:oracle:thin:@192.168.36.112:1521:xe";
		String user = "pc17";
		String pwd = "java";
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	} 
}
