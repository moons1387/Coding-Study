package kr.or.ddit.study09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample03 {

	public static void main(String[] args) {
		ExceptionExample03 obj = new ExceptionExample03();
		obj.process();

	}

	public void process() {
		String[] name = { "홍길동", "이순신", "강감찬" };
		for (int i = 0; i < 3; i++) {
			System.out.println(i + ", " + name[i]);
		}
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				int sel = sc.nextInt();
				String n = name[sel];
				System.out.println(n);
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("범위를 벗어남");
			} catch (InputMismatchException e) {
				System.out.println("문자입력 급지");
			}
		}
	}
}
