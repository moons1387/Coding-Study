package kr.or.ddit.basic.homework08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class HomeWork08 {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork08 hw = new HomeWork08();
		hw.start();
	}

	public void start() {
		BoardManagement bm = new BoardManagement();
		int sel;
		do {
			bm.menu();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				bm.listPrint();
				break;
			case 2:
				bm.insert();
				break;
			case 3:
				bm.update();
				break;
			case 4:
				bm.delete();
				break;
			case 5:
				bm.search();
				break;
			case 6:
				System.out.println("Terminate");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세");
			}
		} while (sel != 6);
	}
}

class BoardManagement {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner sc = new Scanner(System.in);

	public void menu() {
		System.out.println();
		System.out.println("------작업매뉴-------");
		System.out.println("1. 전체 목록 출력");
		System.out.println("2. 새글작정");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 검색");
		System.out.println("6. 종료");
		System.out.println("----------------------");
	}

	public void listPrint() {
		System.out.println();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JDBC_BOARD");
			System.out.println("글번\t제목\t작성자\t작성일");
			while (rs.next()) {
				int no = rs.getInt("BOARD_NO");
				String title = rs.getString("BOARD_TITLE");
				String writer = rs.getString("BOARD_WRITER");
				LocalDate date = rs.getTimestamp("BOARD_DATE").toLocalDateTime().toLocalDate();
				String content = rs.getString("BOARD_CONTENT");
				System.out.println(no + "\t" + title + "\t" + writer + "\t" + date + "\r내용 : " + content);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	public void insert() {
		System.out.print("제목 : ");
		String titleInsert = sc.next();
		System.out.print("작성자 : ");
		String writerInsert = sc.next();
		System.out.print("내용 : ");
		String contentInsert = sc.next();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO JDBC_BOARD "
					+ " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) "
					+ "VALUES(BOARD_SEQ.NEXTVAL,       ?,       ?, TO_DATE(SYSDATE),       ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, titleInsert);
			pstmt.setString(2, writerInsert);
			pstmt.setString(3, contentInsert);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(titleInsert + " 등록 성공!");
			} else {
				System.out.println(titleInsert + " 등록 실패!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	public void update() {
		listPrint();
		System.out.println("수정할 게시물의 제목을 입력하세요");
		System.out.print("제목 : ");
		String titleUpdate = sc.next();
		System.out.println("수정할 내용을 입력하세");
		System.out.print("내용 : ");
		String contentUpdate = sc.next();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE JDBC_BOARD SET BOARD_CONTENT = ? WHERE BOARD_TITLE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, titleUpdate);
			pstmt.setString(2, contentUpdate);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(titleUpdate + " 수정 성공!");
			} else {
				System.out.println(titleUpdate + " 수정 실패!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	public void delete() {
		listPrint();
		System.out.println("삭제할 게시물의 제목을 입력하세요");
		System.out.print("제목 : ");
		String titleDelete = sc.next();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "DELETE JDBC_BOARD WHERE BOARD_TITLE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, titleDelete);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(titleDelete + " 삭제 성공!");
			} else {
				System.out.println(titleDelete + " 삭제 실패!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	public void search() {
		System.out.println("검색할 게시물의 제목을 입력하세요");
		System.out.print("제목 : ");
		String titleSearch = "%" + sc.next() + "%";
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_TITLE LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, titleSearch);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("BOARD_NO");
				String title = rs.getString("BOARD_TITLE");
				String writer = rs.getString("BOARD_WRITER");
				LocalDate date = rs.getTimestamp("BOARD_DATE").toLocalDateTime().toLocalDate();
				String content = rs.getString("BOARD_CONTENT");
				System.out.println(no + "\t" + title + "\t" + writer + "\t" + date + "\r 내용: " + content);
			}
			if (rs.getRow() > 0) {
				System.out.println(rs.getRow() + "개의 글 검색 성공!");
			} else {
				System.out.println("글이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
}