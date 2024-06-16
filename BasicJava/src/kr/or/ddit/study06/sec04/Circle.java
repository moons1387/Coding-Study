package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class Circle {
	// final 선언 - 값이 변하지 않음
	final double PI = Math.PI;
	
	
	// 반지름을 파라미터로 받고 원의 넓이를 구하시오.
	// 넓이 3.14*r*r = area
	// 둘레 2*3.14*r = circumference
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Circle obj = new Circle();
		obj.process();

	}

	public void process() {
//		System.out.println("반지름을 입력하세요.");
//		double r = sc.nextDouble();
//		double area = area(r);
//		System.out.println("넓이 : "+area);
//		double circumference = circumference(r);
//		System.out.println("둘레 : "+circumference);
		
	}
	public double area(double r) {
		return r*r*PI;
	}
	public double circumference(double r) {
		return r*2*PI;
	}
}
