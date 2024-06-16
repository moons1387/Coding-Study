package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class Calculator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Calculator obj = new Calculator();
		obj.process();

	}
	// a, b를 파라미터로 하는 +-/* 각각 메소드를 만드세요.

	public void process() {
		System.out.println("a를 입력하시오");
		double a = sc.nextDouble();
		System.out.println("b를 입력하시오");
		double b = sc.nextDouble();
		double add = method1(a, b);
		System.out.println(a+" + "+b+" = "+add);
		double sub = method2(a, b);
		System.out.println(a+" - "+b+" = "+sub);
		double time = method3(a, b);
		System.out.println(a+" * "+b+" = "+time);
		double divide = method4(a, b);
		System.out.println(a+" / "+b+" = "+divide);
	}

	public double method1(double a, double b) {
		return a + b;
	}

	public double method2(double a, double b) {
		return a - b;
	}

	public double method3(double a, double b) {
		return a * b;
	}

	public double method4(double a, double b) {
		return a / b;
	}
	public double cal(String oper, double a, double b) {
		if(oper.equals("+")) return a+b;
		if(oper.equals("-")) return a-b;
		if(oper.equals("*")) return a*b;
		if(oper.equals(".")) return a/b;
		System.out.println("지원하지 않는 연산입니다.");
		return 0;
	}
}
