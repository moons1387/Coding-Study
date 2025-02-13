package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample05 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample05 obj = new MethodExample05();
		obj.process();

	}

	public void process() {
//		method1();
		method1("");
	}
	public void method1() {
		System.out.println("public void method1()");
		method2(2);
	}
//	public void method1() {
//		System.out.println("public void method1()");
//		return 0;
//	}
	
	public void method1(String str) {
		System.out.println("public void method1(String str)");
		method2();
	}
	public void method2() {
		System.out.println("public void method2()");
		
	}
	public void method2(int a) {
		System.out.println("public void method2(int a)");
		
	}

}
