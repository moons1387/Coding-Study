package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class WhileExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample obj = new WhileExample();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
	}

	public void method1() {
		// while = 종료가 언제 될 지 모를 경우 사용

//		while(true) {
//			System.out.println("a");
//		}

		for (; true;) {
			System.out.println("a");
		}
	}

	public void method2() {
		int i = 1;
		while (i > 0) {
			i += 1006000615;
			System.out.println(i);
		}
	}

	public void method3() {
		while (true) {
			System.out.println("1, 계속");
			System.out.println("2, 종료");
			int num = sc.nextInt();
			if (num == 1) {
				continue;
			}
			if (num == 2) {
				break;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	public void method4() {
		int i = 0;
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		while (num>0) {
				i = i+num%10;
				num/=10;
				System.out.println(i);
			}
		}
	public void method5() {
		// do-while 최초 한번 실행을 보장
		do {
			System.out.println("실행");
		}while(false);
	}
}
