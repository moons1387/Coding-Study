package kr.or.ddit.homewor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.homework.VO.JavaBoardVO;
import kr.or.ddit.util.JDBCUtil;

public class JavaBoardDao implements IJavaBoardDao {

	private static JavaBoardDao jbd = new JavaBoardDao();

	private JavaBoardDao() {

	}

	public static IJavaBoardDao getInstance() {
		return jbd;
	}

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public List<JavaBoardVO> boardList() {

		List<JavaBoardVO> list = new ArrayList<JavaBoardVO>();

		try {

			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JDBC_BOARD");

			while (rs.next()) {

				JavaBoardVO jb = new JavaBoardVO();

				jb.setNo(rs.getInt("BOARD_NO"));
				jb.setTitle(rs.getString("BOARD_TITLE"));
				jb.setWriter(rs.getString("BOARD_WRITER"));
				jb.setRegDate(rs.getTimestamp("BOARD_DATE").toLocalDateTime().toLocalDate());
				jb.setContent(rs.getString("BOARD_CONTENT"));

				list.add(jb);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return list;

	}

	@Override
	public int insert(JavaBoardVO jb) {

		int cnt = 0;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO JDBC_BOARD "
					+ " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) "
					+ "VALUES(BOARD_SEQ.NEXTVAL,       ?,       ?, TO_DATE(SYSDATE),       ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, jb.getTitle());
			pstmt.setString(2, jb.getWriter());
			pstmt.setString(3, jb.getContent());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;

	}

	@Override
	public int delete(int no) {

		int cnt = 0;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "DELETE JDBC_BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(no + " 삭제 성공!");
			} else {
				System.out.println(no + " 삭제 실패!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;

	}

	@Override
	public int update(JavaBoardVO jb) {

		int cnt = 0;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE JDBC_BOARD SET BOARD_CONTENT = ? WHERE BOARD_NO = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, jb.getContent());
			pstmt.setInt(2, jb.getNo());

			cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(jb.getNo() + "번글 수정 성공!");
			} else {
				System.out.println(jb.getNo() + "번 수정 실패!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;

	}

	@Override
	public List<JavaBoardVO> boardSearch(String title) {

		List<JavaBoardVO> list = new ArrayList<JavaBoardVO>();

		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_TITLE LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				JavaBoardVO jb = new JavaBoardVO();
				jb.setNo(rs.getInt("BOARD_NO"));
				jb.setTitle(rs.getString("BOARD_TITLE"));

				list.add(jb);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return list;

	}
}
