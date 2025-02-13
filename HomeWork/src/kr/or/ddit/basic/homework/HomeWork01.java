package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeWork01 {
	public static void main(String[] args) {

		List<Member> list = new ArrayList<Member>();

		Member member3 = new Member("정문성3", "16-10293", 100, 100, 100);
		Member member0 = new Member("정문성0", "16-10290", 90, 90, 90);
		Member member1 = new Member("정문성1", "16-10291", 80, 80, 80);
		Member member2 = new Member("정문성2", "16-10292", 70, 70, 70);
		Member member4 = new Member("정문성4", "16-10294", 90, 90, 90);

		list.add(member0);
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		// 입력순 정렬
		System.out.println("입력순========================================================================");
		for (Member member : list) {
			System.out.println(member);
		}
		Collections.shuffle(list);
		// 학번순 정렬
		System.out.println("학번순========================================================================");
		Collections.sort(list);
		for (Member member : list) {
			System.out.println(member);
		}
		Collections.shuffle(list);
		// 총점순 정렬
		System.out.println("총점순========================================================================");
		Collections.sort(list, new SumDescSort());
		for (Member member : list) {
			member.setRank(list.indexOf(member)+1);
			System.out.println(member);
		}
		Collections.shuffle(list);
		// 등수순 정렬
		System.out.println("등수순========================================================================");
		Collections.sort(list, new RankAscSort());
		for (Member member : list) {
			System.out.println(member);
		}

	}
}

class SumDescSort implements Comparator<Member> {
	// 총점순 정렬
	@Override
	public int compare(Member mem1, Member mem2) {
		if(mem1.getSum()>mem2.getSum()) {
			return -1;
		} else if(mem1.getSum() == mem2.getSum()) {
			return mem1.getStu_no().compareTo(mem2.getStu_no());
		} else
			return 1;
	}

}

class RankAscSort implements Comparator<Member> {
	// 등수순 정렬
	@Override
	public int compare(Member mem1, Member mem2) {
		if(mem1.getRank()>mem2.getRank()) {
			return 1;
		} else if(mem1.getRank() == mem2.getRank()) {
			return 0;
		} else
			return -1;
	}

}

class Member implements Comparable<Member> {

	String name;
	String stu_no;
	int math;
	int eng;
	int kor;
	int sum;
	int rank;

	public Member(String name, String stu_no, int math, int eng, int kor) {
		super();
		this.name = name;
		this.stu_no = stu_no;
		this.math = math;
		this.eng = eng;
		this.kor = kor;
		this.sum = math + eng + kor;
		this.rank = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getSum() {
		return sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "Member [name=" + name + ", stu_no=" + stu_no + ", math=" + math + ", eng=" + eng + ", kor=" + kor
				+ ", sum=" + sum + ", rank=" + rank + "]";
	}

	// 학번순 정렬
	@Override
	public int compareTo(Member mem) {

		return this.getStu_no().compareTo(mem.getStu_no());
	}

}