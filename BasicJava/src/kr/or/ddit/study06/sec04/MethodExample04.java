package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample04 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample04 obj = new MethodExample04();
		obj.process();

	}

	public void process() {
		// 스케너를 통해 a, b 값을 입력 받고
		// add 메소드를 수정하여 a+b 값을 리턴 받아 출력하세요.

		System.out.print("a : ");
		int a = sc.nextInt();
		System.out.print("b : ");
		int b = sc.nextInt();
		int add = add(a, b);
		System.out.println("합 : "+add);
		int sub = sub(a, b);
		System.out.println("차 : "+sub);
		int time = time(a, b);
		System.out.println("곱 : "+time);
		double divide = divide(a, b);
		System.out.println("나누기 : "+divide);
	}
	public int add(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int time(int a, int b) {
		return a*b;
	}
	public double divide(double a, double b) {
		return a/b;
	}
}
