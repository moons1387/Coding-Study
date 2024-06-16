package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample03 obj = new MethodExample03();
		obj.process();

	}

	public void process() {
		System.out.println("메소드1 호출");
		method1();
		System.out.println();
		
		System.out.println("메소드2 호출");
		int m2 = method2();
		System.out.println("메소드2에서 받은 리턴값: "+m2);
		System.out.println();
		
		System.out.println("메소드3 호출");
		String m3 = method3();
		System.out.println("메소드3에서 받은 리턴값: "+m3);

	}
	public void method1() {
		System.out.println("void는 리턴 값이 없어요.");
		 
	}
	public int method2() {
		System.out.println("(method2)숫자를 입력하세요.");
		return sc.nextInt();
	}
	public String method3() {
		System.out.println("(method3)문자를 입력하세요.");
		return sc.next();
	}
}
