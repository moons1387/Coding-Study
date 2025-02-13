 package kr.or.ddit.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HomeWork20 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork20 obj = new HomeWork20();
		obj.process();
	}

	Map<String, Student2> data = new HashMap();
	int cnt = 0;
	String loginId = null;
	private Iterator it;

	public void process() {
		while (true) {
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 탈퇴");
			System.out.println("3. 정보 수정 ");
			System.out.println("4. 내정보 출력");
			System.out.println("5. 로그인 ");
			System.out.println("6. 로그아웃 ");
			System.out.println("7. 종료");
			int sel = sc.nextInt();
			if (sel == 1)
				insert();
			if (sel == 2)
				delete();
			if (sel == 3)
				update();
			if (sel == 4)
				print();
			if (sel == 5)
				login();
			if (sel == 6)
				logout();
			if (sel == 7)
				break;
		}
	}

	public void insert() {
		Student2 std = new Student2();
		while (true) {
			System.out.print("ID : ");
			std.id = sc.next();
			System.out.print("PW : ");
			std.pass = sc.next();
			System.out.print("name : ");
			std.name = sc.next();
			// id 중복 체크
			if (cnt == 0) {
				data.put(std.id, std);
				System.out.println("회원 생성 완료");
				cnt++;
				break;
			}
			if (!idCheck(std.id, std.pass)) {
				data.put(std.id, std);
				System.out.println("회원 생성 완료");
				break;
			} else {
				System.out.println("중복된 ID");
				continue;
			}
		}

	}

	public void delete() {
		// 로그인 후 id pass 같을 경우 회원 탈퇴
		while (loginCheck()) {
			String idKey;
			String passKey;
			System.out.print("ID : ");
			idKey = sc.next();
			System.out.print("PW : ");
			passKey = sc.next();
			if (!idCheck(idKey, passKey)) {
				data.remove(idKey);
				System.out.println("정보 삭제 완료");
				cnt--;
				break;
			} else {
				System.out.println("정보 불일치");
				continue;
			}
		}
	}

	public void update() {
		// 로그인 후 id pass 같을 경우 수정
		boolean flag = true;
		flag = loginCheck();
		while (flag) {
			String idKey;
			String passKey;
			System.out.print("ID : ");
			idKey = sc.next();
			System.out.print("PW : ");
			passKey = sc.next();
			if (!idCheck(idKey, passKey)) {
				System.out.println("정보가 없음");
				continue;
			} else {
				Student2 stdN = new Student2();
				while (flag) {
					System.out.println("수정할 내용 작성");
					System.out.print("ID : ");
					stdN.id = sc.next();
					System.out.print("PW : ");
					stdN.pass = sc.next();
					System.out.print("name : ");
					stdN.name = sc.next();
					// id 중복 체크
					if (!idCheck(stdN.id, stdN.pass)) {
						data.remove(idKey);
						data.put(stdN.id, stdN);
						loginId = stdN.id;
						System.out.println("정보 수정 완료");
						flag = false;
					} else {
						System.out.println("중복된 ID");
						continue;
					}
				}
			}
		}
	}

	public void print() {
		System.out.println("회원 ID  : " + data.get(loginId).id + 
						 "\n회원 PW  : " + data.get(loginId).pass + 
						 "\n회원이름 : " + data.get(loginId).name);
		// 로그인 후 본인 정보 출력
	}

	public void login() {
		// 로그인 (loginId != null;)
		while (true) {
			String idKey;
			String passKey;
			System.out.print("ID : ");
			idKey = sc.next();
			System.out.print("PW : ");
			passKey = sc.next();
			if (!idCheck(idKey, passKey)) {
				System.out.println("로그인 실패");
				continue;
			} else {
				System.out.println("로그인 성공");
				loginId = idKey;
				break;
			}
		}

	}

	public void logout() {
		// 로그 아웃
		loginId = null;

	}

	public boolean idCheck(String id, String pass) {
		if (data.containsKey(id)) {
			if (pass.equals(data.get(id).pass)) {
				return true;
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean loginCheck() {
		if (loginId != null) {
			return true;
		} else {
			System.out.println("로그인 후 사용가능");
			return false;
		}
	}

}

class Student2 {
	String id;
	String pass;
	String name;

}
