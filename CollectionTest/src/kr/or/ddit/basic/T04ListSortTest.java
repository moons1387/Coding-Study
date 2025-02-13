package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSortTest {
	public static void main(String[] args) {
		List<Member> memlist = new ArrayList<Member>();

		memlist.add(new Member(1, "홍길동", "010-1111-1111"));
		memlist.add(new Member(5, "변학도", "010-2222-1111"));
		memlist.add(new Member(9, "성춘향", "010-3333-1111"));
		memlist.add(new Member(3, "이순신", "010-4444-1111"));
		memlist.add(new Member(6, "강감찬", "010-5555-1111"));
		memlist.add(new Member(2, "일지매", "010-6666-1111"));

		System.out.println("정렬 전 : ");
		for (Member mem : memlist) {
			System.out.println(mem);
		}
		System.out.println("================================================");

		Collections.sort(memlist);
		/*
		 * 이름 오름차순 정렬 후
		 */
		System.out.println("이름 오름차순 정렬 후 : ");
		for (Member mem : memlist) {
			System.out.println(mem);
		}
		System.out.println("================================================");

		Collections.shuffle(memlist);
		/*
		 * 번호의 내림차순
		 */
		System.out.println("번호 내림차순 정렬 후 : ");
		Collections.sort(memlist, new SortNumDesc());
		for (Member member : memlist) {
			System.out.println(member);
		}
		System.out.println("==================================================");
	
	}
}

// Member 객체의 번호를 내림차순으로 정렬하기
class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {

		// 방법 1
//		if (mem1.getNum() > mem2.getNum()) {
//			return -1;
//		} else if (mem1.getNum() == mem2.getNum()) {
//			return 0;
//		} else {
//			return 1;
//		}
		
		// 방법 2
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;

		// 방법 3
		return Integer.compare(mem1.getNum(), mem2.getNum())*-1;
	}

}

class Member implements Comparable<Member> {
	/*
	 * 이름을 기준으로 오름차순 정렬이 되도록 구현한다.
	 */
	@Override
	public int compareTo(Member mem) {

		return this.getName().compareTo(mem.getName());
	}

	private int num;
	private String name;
	private String tel;

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

}