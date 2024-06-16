package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample02 obj = new MethodExample02();
		obj.process();

	}

	public void process() {
		// 스케너를 통해 a, b 값을 입력받고
		// add 메소드를 수정하여 a+b값을 출력 하시오.
		System.out.println("a 입력");
		int a = sc.nextInt();
		System.out.println("b 입력");
		int b = sc.nextInt();
		add(a, b);
		sub(a, b);
		time(a, b);
		divide(a, b);
	}
	public void add(int a, int b) {
		int add = a+b;
		System.out.print("합 : ");
		System.out.print(add);
		System.out.println();
	}
	public void sub(int a, int b) {
		int sub = a-b;
		System.out.print("차 : ");
		System.out.print(sub);
		System.out.println();
	}
	public void time(int a, int b) {
		int time = a*b;
		System.out.print("곱 : ");
		System.out.print(time);
		System.out.println();
	}
	public void divide(int a, int b) {
		int divide = a/b;
		System.out.print("나누기 : ");
		System.out.print(divide);
		System.out.println();
	}
	
}
