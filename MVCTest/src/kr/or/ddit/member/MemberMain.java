package kr.or.ddit.member;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.member.dao.MemberDaoImplWithJDBC;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

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
public class MemberMain {

	private Scanner scan;
	private IMemberService memService;

	public MemberMain() {
		memService = new MemberServiceImpl();
		scan = new Scanner(System.in);
	}

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

		List<MemberVO> memList = memService.getTotalMember();

		if (memList.size() == 0) {
			System.out.println("회원정보가 존재하지 않습니다.");
		} else {
			for (MemberVO mv : memList) {
				System.out.println(mv.getMemId() + "\t" + mv.getRegDt() + "\t" + mv.getMemName() + "\t" + mv.getMemTel()
						+ "\t" + mv.getMemAddr());
			}
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println("출력끝...");

	}

	private void deletMember() {

		String memId = "";
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력해 주세요");
		System.out.print("회원 ID : ");
		memId = scan.next();

		if (memService.removeMember(memId) > 0) {
			System.out.println(memId + "인 회원정보 삭제 성공!");
		} else {
			System.out.println(memId + "인 회원정보 삭제 실패!!!");
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

			isExist = memService.checkMember(memId);

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

		/////////////////////////////////////////////////////////////////////////////////////

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);

		if (memService.modifyMember(mv) > 0) {
			System.out.println(memId + "인 회원정보 수정 성공!");
		} else {
			System.out.println(memId + "인 회원정보 수정 실패!!!");
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

			isExist = memService.checkMember(memId);

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

		MemberVO mv = new MemberVO();

		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);

		if (memService.registerMember(mv) > 0) {
			System.out.println(memId + "인 회원정보 등록 성공!");
		} else {
			System.out.println(memId + "인 회원정보 등록 실패!!!");
		}
	}

	/**
	 * 회원정보가 존재하는지 체크하기 위한 메서드
	 * 
	 * @param memId
	 * @return
	 */

	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		memObj.start();
	}

}