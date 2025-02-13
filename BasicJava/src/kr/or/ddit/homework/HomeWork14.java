package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork14 {
	static Scanner sc = new Scanner(System.in);
	int cur = 0;
	Mem[] memList = new Mem[100];

	public static void main(String[] args) {
		HomeWork14 h14 = new HomeWork14();
		while (true) {
			System.out.println("1. 회원 가입.");
			System.out.println("2. 회원 탈퇴.");
			System.out.println("3. 정보 수정.");
			System.out.println("4. 회원 전체 정보 출력.");
			System.out.println("5. 종료.");
			int sel = sc.nextInt();
			if (sel == 1) {
				h14.addMember();
			}
			if (sel == 2) {
				h14.deleteMember();
			}
			if (sel == 3) {
				h14.updateMember();
			}
			if (sel == 4) {
				h14.printMemberList();
			}
			if (sel == 5) {
				break;
			}
		}
	}

	public void addMember() {
		Mem newmem = new Mem();
		System.out.println("ID를 입력하세요.");
		String ID = sc.next();
		ID = checkID(ID);
		newmem.setId(ID);
		System.out.println("PW를 입력하세요.");
		String PW = sc.next();
		newmem.setPass(PW);
		System.out.println("이름을 입력하세요.");
		String nm = sc.next();
		newmem.setName(nm);
		System.out.println("나이를 입력하세요.(0~122)");
		int a = sc.nextInt();
		a = checkAge(a);
		newmem.setAge(a);
		memList[cur] = newmem;
		cur++;
	}

	public String checkID(String ID) {
		boolean flag = true;
		if (cur == 0)
			flag = false;
		while (flag) {
			for (int i = 0; i < cur; i++) {
				Mem mem = memList[i];
				if (mem.getId().equals(ID)) {
					System.out.println("아이디 중복. \n다시 입력하세요.");
					ID = sc.next();
				} else {
					flag = false;
				}
			}
		}
		return ID;
	}

	public int checkAge(int age) {
		while (age < 0 || age > 122) {
			System.out.println("다시 입력하세요.");
			age = sc.nextInt();
		}
		return age;
	}

	public void deleteMember() {
		boolean flag = true;
		if(cur==0) {
			System.out.println("회원정보가 없습니다.");
			flag = false;
		}
		while (flag) {
			printMemberList();
			System.out.println("삭제할 회원정보를 선택하세요.");
			int num = sc.nextInt() - 1;
			if (num >= cur || num < 0) {
				continue;
			}
			for (int i = num; i < cur; i++) {
				memList[i] = memList[i + 1];
			}
			cur--;
			printMemberList();
			System.out.println("삭제완료.");
			break;
		}
	}

	/*
	 * 회원 전체 정보 출력하기.
	 */
	public void printMemberList() {
		if(cur==0) {
			System.out.println("회원정보가 없습니다.");
		}
		for (int i = 0; i < cur; i++) {
			Mem mem = memList[i];
			// getMethod 이용해서 출력
			String mem_id = mem.getId();
			String mem_pw = mem.getPass();
			String mem_name = mem.getName();
			int mem_age = mem.getAge();
			System.out.println("회원번호 : " + (i + 1) + "\t 아이디 : " + mem_id + "\t 비밀번호 : " + mem_pw + "\t 이름 : "
					+ mem_name + "\t 나이 : " + mem_age);
		}
	}

	/*
	 * 회원 정보 수정하기.
	 */
	public void updateMember() {
		/*
		 * 회원 전체 정보 출력하기.
		 */
		printMemberList();
		
		System.out.print("수정할 회원 번호 입력.");
		int num = sc.nextInt();
		Mem mem = memList[num - 1];
		System.out.print("ID 수정 : ");
		String newID = sc.next();
		newID = checkID(newID);
		mem.setId(newID);
		System.out.print("PW 수정 : ");
		String newPW = sc.next();
		mem.setPass(newPW);
		System.out.print("이름 수정 : ");
		String newName = sc.next();
		mem.setName(newName);
		System.out.println("나이 수정 : ");
		int newAge = sc.nextInt();
		mem.setAge(newAge);
		memList[num - 1] = mem;
		System.out.println("회원번호 : " + (num) + "\t 아이디 : " + newID + "\t 비밀번호 : " + newPW + "\t 이름 : " + newName
				+ "\t 나이 : " + newAge);
		System.out.println("수정 되었습니다.");
		/*
		 * 정보 수정.
		 */
	}

}

class Mem {

	private String id;
	private String pass;
	private String name;
	private int age;

	/*
	 * 생성자 사용x getter setter 이용할것.
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Mem [id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + "]";
	}

}
