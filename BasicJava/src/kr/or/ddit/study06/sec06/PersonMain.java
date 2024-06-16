package kr.or.ddit.study06.sec06;

import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Person p1 = new Person();
		p1.setName("");
		int age = sc.nextInt();
		p1.setAge(age);
	}
}
