package kr.or.ddit.basic;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.basic.service.IMyBatisBoardService;
import kr.or.ddit.basic.service.MyBatisBoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class MyBatisBoard {
	private Scanner sc = new Scanner(System.in);

	IMyBatisBoardService boardService = null;

	public MyBatisBoard() {
		boardService = MyBatisBoardServiceImpl.getInstance();
	}

	public static void main(String[] args) {

		MyBatisBoard hw = new MyBatisBoard();
		hw.start();
		
	}

	public void start() {
		int sel;
		do {
			menu();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				listPrint();
				break;
			case 2:
				insert();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				search();
				break;
			case 6:
				System.out.println("Terminate");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세");
			}
		} while (sel != 6);
	}

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

		List<BoardVO> boardList = boardService.allBoard();

		Collections.sort(boardList);

		System.out.println("\r글번호\t글재목\t작성자\t\t내용\r ");

		for (BoardVO bd : boardList) {
			int no = bd.getBdNo();
			String title = bd.getBdTitle();
			String writer = bd.getBdWriter();
			String content = bd.getBdContent();
//			LocalDate regDate = bd.getBdDate();

			System.out.println(no + "\t" + title + "\t" + writer + "\t\t" + content + "\r ");
		}
	}

	public void insert() {

		System.out.print("제목 : ");
		String titleInsert = sc.next();
		System.out.print("작성자 : ");
		String writerInsert = sc.next();
		System.out.print("내용 : ");
		String contentInsert = sc.next();

		BoardVO bv = new BoardVO();
		bv.setBdTitle(titleInsert);
		bv.setBdWriter(writerInsert);
		bv.setBdContent(contentInsert);

		int cnt = boardService.insert(bv);

		if (cnt > 0) {
			System.out.println("insert 성공!");
		} else {
			System.out.println("insert 실패");
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

		BoardVO bv = new BoardVO();
		bv.setBdNo(noUpdate);
		bv.setBdContent(contentUpdate);

		int cnt = boardService.update(bv);

		if (cnt > 0) {
			System.out.println("update 성공");
		} else {
			System.out.println("실패");
		}

	}

	public void delete() {

		listPrint();

		System.out.println("삭제할 게시물의 번호를 입력하세요");
		System.out.print("번호 : ");

		int noDelete = sc.nextInt();

		int cnt = boardService.delete(noDelete);

		if (cnt > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public void search() {

		System.out.println("검색할 게시물의 제목을 입력하세요");
		System.out.print("제목 : ");
		String boardName = "%" + sc.next() + "%";

		List<BoardVO> boardList = boardService.searchBoard(boardName);
		
		System.out.println("\r글번호\t글재목\t작성자\t\t내용\r ");

		for (BoardVO bd : boardList) {
			int no = bd.getBdNo();
			String title = bd.getBdTitle();
			String writer = bd.getBdWriter();
			String content = bd.getBdContent();

			System.out.println(no + "\t" + title + "\t" + writer + "\t\t" + content + "\r ");
		}
		
		System.out.println(boardList.size() + "개 검색정보 출력 끝...");
	}
}