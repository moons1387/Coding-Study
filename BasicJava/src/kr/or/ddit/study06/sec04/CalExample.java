package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class CalExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator cal = new Calculator();

		System.out.println("숫자를 입력하세요.");
		double a = sc.nextDouble();
		System.out.println("연산자를 입력하세요.");
		String oper = sc.next();
		System.out.println("숫자를 입력하세요.");
		double b = sc.nextDouble();
		
		double result = cal.cal(oper, a, b);
		
		System.out.println(a+oper+b+"="+result);
	}

}
