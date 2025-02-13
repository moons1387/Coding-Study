

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil3;

/*
   회원정보를 관리하는 프로그램을 작성하는데 
   아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
   (DB의 MYMEMBER테이블을 이용하여 작업한다.)
   
   * 자료 삭제는 회원ID를 입력 받아서 삭제한다.
   
   예시메뉴)
   ----------------------
      == 작업 선택 ==
      1. 자료 입력         ---> insert
      2. 자료 삭제         ---> delete
      3. 자료 수정         ---> update
      4. 전체 자료 출력   ---> select
      5. 작업 끝.
   ----------------------

*/
public class T01MemberInfoTest {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {

		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deletMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				displayAllMember();
				break;
			case 5: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 5);
	}

	private void displayAllMember() {
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println("ID\t생성일\t이 름\t전화번호\t주소");
		System.out.println("------------------------------------------------------------------");
		
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
				
				System.out.println(memId+"\t"+regDtDate+"\t"+memName+"\t"+memTel+"\t"+memAddr);
			}
			System.out.println("------------------------------------------------------------------");
			System.out.println("출력끝...");

			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
	}

	private void deletMember() {

		String memId = "";
			System.out.println();
			System.out.println("삭제할 회원 정보를 입력해 주세요");
			System.out.print("회원 ID : ");
			memId = scan.next();
			
			try {
				conn = JDBCUtil3.getConnection();
				
				String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sql);
				
				int cnt = pstmt.executeUpdate();
				
				if (cnt > 0) {
					System.out.println(memId + "인 회원정보 삭제 성공!");
				} else {
					System.out.println(memId + "인 회원정보 삭제 실패!!!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil3.close(conn, stmt, pstmt, rs);
			}

	}
	

	private void updateMember() {

		boolean isExist = false;

		String memId = "";

		do {

			System.out.println();
			System.out.println("수정할 회원 정보를 입력해 주세요");

			System.out.print("회원 ID : ");
			memId = scan.next();

			isExist = checkMember(memId);

			if (!isExist) {
				System.out.println("회원ID가" + memId + "인 회원은 존재하지 않습니다.");
			}

		} while (!isExist);

		System.out.print("회원 이름 : ");
		String memName = scan.next();

		System.out.print("회원 전번 : ");
		String memTel = scan.next();

		scan.nextLine(); // 입력버퍼에 남아있는 엔터키 제거용...

		System.out.print("회원 주소 : ");
		String memAddr = scan.nextLine();
	
	///////////////////////////////////////////
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);
					
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(memId + "인 회원정보 수정 성공!");
			} else {
				System.out.println(memId + "인 회원정보 수정 실패!!!");
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 회원정보를 등록하기 위한 메서드
	 */
	private void insertMember() {

		boolean isExist = false;

		String memId = "";

		do {

			System.out.println();
			System.out.println("추가할 회원 정보를 입력해 주세요");

			System.out.print("회원 ID : ");
			memId = scan.next();

			isExist = checkMember(memId);

			if (isExist) {
				System.out.println("회원ID가" + memId + "인 회원은 이미 존재합니다. \r다시 입력해주세요.");
			}

		} while (isExist);

		System.out.print("회원 이름 : ");
		String memName = scan.next();

		System.out.print("회원 전번 : ");
		String memTel = scan.next();

		scan.nextLine(); // 입력버퍼에 남아있는 엔터키 제거용...

		System.out.print("회원 주소 : ");
		String memAddr = scan.nextLine();

		////////////////////////////////////////////////////////////////////////////

		try {

			conn = JDBCUtil3.getConnection();

			String sql = " insert into MYMEMBER(mem_id, mem_name, mem_tel, mem_addr) \r\n" + " values (?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "인 회원정보 등록 성공!");
			} else {
				System.out.println(memId + "인 회원정보 등록 실패!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 회원정보가 존재하는지 체크하기 위한 메서드
	 * 
	 * @param memId
	 * @return
	 */
	private boolean checkMember(String memId) {

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

			if (cnt > 0) {
				isExist = true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// 자원반납
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return isExist;
	}

	public static void main(String[] args) {
		T01MemberInfoTest memObj = new T01MemberInfoTest();
		memObj.start();
	}

}