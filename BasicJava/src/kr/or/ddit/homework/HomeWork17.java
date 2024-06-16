package kr.or.ddit.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork17 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork17 obj = new HomeWork17();
		obj.process();
	}

	public void process() {
		while (true) {
			System.out.println("1. 회원 가입.");
			System.out.println("2. 회원 탈퇴.");
			System.out.println("3. 정보 수정.");
			System.out.println("4. 회원 전체 정보 출력.");
			int sel = sc.nextInt();
			if (sel == 1) {
				addMember();
			}
			if (sel == 2) {
				removeMember();
			}
			if (sel == 3) {
				updateMember();
			}
			if (sel == 4) {
				printMemberList();
			}
		}
	}

	int cur = 0;
	Member[] memList = new Member[100];

	public Member addMember() {
		// id 입력시 4~8자 입력 받을것.
		Member mem = new Member();
		String id;
		System.out.println("ID 4 ~ 8 자 입력");
		while (true) {
			id = sc.next();
			try {
				idCheck(id);
				mem.setId(id);
				break;
			} catch (Exception e) {
				System.out.println("ID 4 ~ 8 자 입력");
				continue;
			}
		}
		// pass 입력시 4~8자 입력
		String pass;
		System.out.println("PW 4 ~ 8 자 입력");
		while (true) {
			pass = sc.next();
			try {
				passCheck(pass);
				mem.setPass(pass);
				break;
			} catch (Exception e) {
				System.out.println("PW 4 ~ 8 자 입력");
				continue;
			}
		}
		// name 입력시 2~5자 입력
		String name;
		System.out.println("이름 2 ~ 5 자 입력");
		while (true) {
			name = sc.next();
			try {
				nameCheck(name);
				mem.setName(name);
				break;
			} catch (Exception e) {
				System.out.println("이름 2 ~ 5 자 입력");
				continue;
			}
		}
		// nickName 2~8자 입력시 욕설등 금지어 체크
		String nickName;
		System.out.println("별명 2 ~ 8 자 입력\n비속어 사용 금지");
		while (true) {
			nickName = sc.next();
			try {
				nickNameCheck(nickName);
				mem.setNickName(nickName);
				break;
			} catch (Exception e) {
				System.out.println("별명 2 ~ 8 자 입력\n비속어 사용 금지");
				continue;
			}
		}
		// age 숫자 입력 체크
		int age;
		System.out.println("0~122 까지 숫자 입력");
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				age = sc.nextInt();
				ageCheck(age);
				mem.setAge(age);
				break;
			}  catch (InputMismatchException e) {
				System.out.println("0~122 까지 숫자 입력");
				continue;
			} catch (Exception e) {
				System.out.println("0~122 까지 숫자 입력");
				continue;
			} 
		}
		memList[cur] = mem;
		cur++;
		return mem;
	}

	public void idCheck(String id) throws Exception {
		if (id.length() < 4 || id.length() > 8) {
			throw new Exception();
		}
	}

	public void passCheck(String pass) throws Exception {
		if (pass.length() < 4 || pass.length() > 8) {
			throw new Exception();
		}
	}

	public void nameCheck(String name) throws Exception {
		if (name.length() < 2 || name.length() > 5) {
			throw new Exception();
		}
	}

	public void nickNameCheck(String nickName) throws Exception {
		if (nickName.length() < 2 || nickName.length() > 8) {
			throw new Exception();
		}
		String[] curse = { "욕설", "비속어" };
		for (int i = 0; i < curse.length; i++) {
			if (nickName.equals(curse[i])) {
				throw new Exception();
			}
		}
	}

	public void ageCheck(int age) throws Exception {
		if (age < 0 || age > 122) {
			throw new Exception();
		}
	}

	public void removeMember() {
		for (int i = 0; i < cur; i++) {
			System.out.println((i + 1) + " : " + memList[i]);
		}
		int sel = sc.nextInt() - 1;
		for (int i = sel; i < memList.length - 1; i++) {
			memList[i] = memList[i + 1];
		}
		cur--;
	}

	public void updateMember() {
		for (int i = 0; i < cur; i++) {
			System.out.println((i + 1) + " : " + memList[i]);
		}
		int sel = sc.nextInt() - 1;
		Member upMem = new Member();
		upMem = addMember();
		memList[sel] = upMem;
		cur--;
	}

	public void printMemberList() {
		for (int i = 0; i < cur; i++) {
			System.out.println((i + 1) + " : " + memList[i]);
		}
	}

}

class Member {
	private String id;
	private String pass;
	private String name;
	private String nickName;
	private int age;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", nickName=" + nickName + ", age=" + age
				+ "]";
	}

}
