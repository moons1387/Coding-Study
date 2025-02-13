package kr.or.ddit.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.homework.VO.JavaBoardVO;
import kr.or.ddit.homework.service.JavaBoardService;
import kr.or.ddit.util.JDBCUtil;

public class JavaBoard {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JavaBoard hw = new JavaBoard();
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

	JavaBoardService jbs = JavaBoardService.getInstance();

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

		List<JavaBoardVO> boardList = jbs.boardList();
		Collections.sort(boardList);
		
		System.out.println("\r글번호\t글재목\t작성자\t게시일\t\t내용\r ");

		for (JavaBoardVO jb : boardList) {
			int no = jb.getNo();
			String title = jb.getTitle();
			String writer = jb.getWriter();
			String content = jb.getContent();
			LocalDate regDate = jb.getRegDate();

			System.out.println(no + "\t" + title + "\t" + writer + "\t" + regDate + "\t" + content + "\r ");
		}
	}

	public void insert() {

		System.out.print("제목 : ");
		String titleInsert = sc.next();
		System.out.print("작성자 : ");
		String writerInsert = sc.next();
		System.out.print("내용 : ");
		String contentInsert = sc.next();

		JavaBoardVO jb = new JavaBoardVO();
		jb.setTitle(titleInsert);
		jb.setWriter(writerInsert);
		jb.setContent(contentInsert);

		if (jbs.insert(jb) > 0) {
			System.out.println("\r"+titleInsert + " 등록 성공!");
		} else {
			System.out.println("\r"+titleInsert + " 등록 실패!!!");
		}

	}

	public void update() {

		listPrint();

		System.out.println("수정할 게시물의 번호를 입력하세요");
		System.out.print("번호 : ");
		int noUpdate = sc.nextInt();
		System.out.println("수정할 내용을 입력하세");
		System.out.print("내용 : ");
		String contentUpdate = sc.next();

		JavaBoardVO jb = new JavaBoardVO();
		jb.setNo(noUpdate);
		jb.setContent(contentUpdate);

		if (jbs.update(jb) > 0) {
			System.out.println(noUpdate + "번글 수정 성공!");
		} else {
			System.out.println(noUpdate + "번글 수정 실패!!!");
		}

	}

	public void delete() {

		listPrint();

		System.out.println("삭제할 게시물의 번호를 입력하세요");
		System.out.print("번호 : ");

		int noDelete = sc.nextInt();

		if (jbs.delete(noDelete) > 0) {
			System.out.println(noDelete + " 삭제 성공!");
		} else {
			System.out.println(noDelete + " 삭제 실패!!!");
		}

	}

	public void search() {
		
		System.out.println("검색할 게시물의 제목을 입력하세요");
		System.out.print("제목 : ");
		String titleSearch = "%" + sc.next() + "%";
		
		List<JavaBoardVO> list = jbs.boardSearch(titleSearch);
		Collections.sort(list);
		
		if (list.size() > 0) {
			
			System.out.println("\r글번호\t제목\r ");
			
			for (JavaBoardVO jb : list) {
				int no = jb.getNo();
				String title = jb.getTitle();
				
				System.out.println(no+"\t"+title+"\r ");
			}
			
			System.out.println(list.size() + "개의 글 검색 성공!");
		} else {
			System.out.println("글이 없습니다.");
		}
		
	}
}