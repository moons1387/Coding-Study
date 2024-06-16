package kr.or.ddit.study09;

import java.util.Scanner;

public class ExceptionExample02 {

	public static void main(String[] args) {
		ExceptionExample02 obj = new ExceptionExample02();
		obj.process();

	}

	public void process() {
		int sel;
		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("숫자를 입력하세요");
				sel = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("에러");
			}
		}
		System.out.println(sel);
	}
}
