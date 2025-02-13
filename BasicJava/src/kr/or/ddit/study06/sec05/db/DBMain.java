package kr.or.ddit.study06.sec05.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) {
		DBMain obj = new DBMain();
		obj.process();
	}

	public void process() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DBConn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER";
			rs = stmt.executeQuery(sql);

			while(rs.next()) { // 값이 있으면 가져온다
				String id = rs.getString("mem_id");
				String name = rs.getString("mem_name");
				String job = rs.getString("mem_job");
				if(!job.equals("주부")) continue;
				String mail = rs.getString("mem_mail");
				String like = rs.getString("mem_like");
				System.out.println(id+"\t"+name+"\t"+job+"\t"+mail+"\t"+like);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
