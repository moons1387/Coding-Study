package kr.or.ddit.study07;

import java.util.Scanner;

public class StringExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringExample obj = new StringExample();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
		method9();
	}

	public void method1() {
		String test = "AbCd";

		test = test.toUpperCase();
		System.out.println(test);

		test = test.toLowerCase();
		System.out.println(test);
	}

	public void method2() {
		// split 내 문자를 기준으로 배열
		String test = "a, b, c";
		String[] tokens = test.split(",");
		for (String token : tokens) {
			token = token.trim();
			System.out.println(token);
		}
	}

	public void method3() {
		// 앞 뒤 공백을 제거함
		String space = " a b c \n\n\r \r\n";
		System.out.println(space);
		space = space.trim();
		System.out.println(space);
	}

	public void method4() {
		// 문자열 대체
		String str = "ooo 바보 바보 바보 바보";
		str = str.replace("바보", "");
		System.out.println(str);
	}

	public void method5() {
		// 문자열 자르기
		String str = "123456";
		str = str.substring(2, 4);
		System.out.println(str);
	}

	public void method6() {
		String str = "Book1.csv";
		if (str.startsWith("Book1")) {
			System.out.println("Book1로 시작합니다.");
		}
		if (str.endsWith(".csv")) {
			System.out.println(".csv로 끝납니다.");
		}
	}

	public void method7() {
		String test = "문자열 test 입니다.";
		if (test.contains("test")) {
			System.out.println("test 문자가 포함되어있다.");
		}
	}

	public void method8() {
		String str = null;

		if (str == null || str.isEmpty()) {
			System.out.println("빈 문자열");
		}
//		if (str.isEmpty() || str == null) {
//			System.out.println("빈 문자열");
//		}
	}

	public void method9() {
		System.out.println("계속 하시겠습니까(y/n)");
		String yn = sc.next();
//		if (yn.equals("y")) 
		if (yn.equalsIgnoreCase("y")) {
			System.out.println("계속");
		} else {
			System.out.println("종료");
		}
	}
}
