package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImplWithJDBC implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {

			conn = JDBCUtil3.getConnection();

			String sql = " insert into MYMEMBER(mem_id, mem_name, mem_tel, mem_addr) \r\n" + " values (?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false;
		try {

			conn = JDBCUtil3.getConnection();

			String sql = "SELECT COUNT(*) AS CNT FROM MYMEMBER WHERE MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sql);
			
			rs = pstmt.executeQuery();

			int cnt = 0;
			while (rs.next()) {
				cnt = rs.getInt("CNT");
			}
			if (cnt > 0) isExist = true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// 자원반납
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return isExist;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sql);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil3.getConnection();
			
			stmt = conn.createStatement();
					
			rs = stmt.executeQuery("SELECT * FROM MYMEMBER");
			
			while (rs.next()) {
				
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String memTel = rs.getString("MEM_TEL");
				String memAddr = rs.getString("MEM_ADDR");
				LocalDate regDtDate = rs.getTimestamp("reg_dt").toLocalDateTime().toLocalDate();
				
				MemberVO mv = new MemberVO();
				
				mv.setMemId(memId);
				mv.setMemName(memName);
				mv.setMemTel(memTel);
				mv.setMemAddr(memAddr);
				mv.setRegDt(regDtDate);
				
				memList.add(mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return memList;
	}
}
