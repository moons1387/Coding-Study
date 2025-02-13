package kr.or.ddit.study03;

import java.util.Scanner;

public class BinaryOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BinaryOperator obj = new BinaryOperator();
		obj.process();

	}

	public void process() {
		// 이항연산자 : 대부분의 연산자 - 산술연산자, 관계연산자, 논리 연산자, 비트 연산자, 대입연산자.
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
		method6();
	}

	public void method1() {
		// 산술연산자
		// 종류 : +, -, /, *, %
		// 사칙연산과 마찬가지로 /, * 먼저 적용된다.

		int a = 5;
		int b = 3;

		System.out.println("덧셈\t" + (a + b));
		// 5 + 3 = 8
		System.out.println("뺄셈\t" + (a - b));
		// 5 - 3 = 2
		System.out.println("나눗셈\t" + (a / b));
		// 5 / 3 = 1.xx
		System.out.println("곱셈\t" + (a * b));
		// 5 * 3 = 15
		System.out.println("나머지셈\t" + (a % b));
		// 5 % 3 = 3*1 + "2"

	}

	public void method2() {
		// 관계연산자 : 참 거짓으로 결과가 나옴
		// <, >, ==, >=, <=, !=

		System.out.print("점수를 입력 하세요 : ");
		int num = sc.nextInt();

		// 100~90 A
		if (num >= 90) {
			System.out.println("Grade A");
		}
		int a = 10;
		int b = 10;
		if (a == b) {
			System.out.println("a=b");

		}
		int a1 = 1;
		int b1 = 1;
		if (a1 != b1 + 1) {
			System.out.println("a != b");
		}
	}

	public void method3() {
		// 논리연산자
		// && : 논리 곱 - 둘다 참일 때 참
		// || : 논리 합 - 둘중 하나가 참일 때 참 또는 둘다 거짓일 때 거짓
		// ! : 부정 - 참과 거짓을 반대로 바꾸어줌(!false = true)
		boolean a = true;
		boolean b = false;
		System.out.println(a && b);
		System.out.println(a && !b);
		System.out.println(a || b);
		System.out.println(!a || b);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		// B 학점
		// 90>B 학점>=80
		if (score < 90 && score >= 80) {
			System.out.println("B 학점");
		}
	}

	public void method4() {
		// 대입 연산자.
		// = : '=' 오른쪽의 값을 '=' 왼쪽에 저장, 우선순위가 가장 낮다
		// '='과 다른 연산자가 결합
		// a=a+b => a+=b
		// a=a-b => a-=b
		// a=a/b => a/=b
		// a=a*b => a*=b
		// a=a%b => a%=b

		int x = 10;
		int y = 15;
		int result = x + y;
		System.out.println(result);

		int a = 10;
		int b = 4;
		System.out.println("a=a+b => a+=b : " + (a += b));
		System.out.println("a=a-b => a-=b : " + (a -= b));
		System.out.println("a=a/b => a/=b : " + (a /= b));
		System.out.println("a=a*b => a*=b : " + (a *= b));
		System.out.println("a=a%b => a%=b : " + (a %= b));

	}

	public void method5() {
		// 논리연산자
		// |, &, ~
		
		int a = 45;
		int b = 25;
		//            &      |      |             |          ~(not) 
		// 45  :  00101101   |   00101101  :  45  |  45  :  00101101
		// 25  :  00011001   |   00011001  :  25  |
		//  9  :  00001001   |   00111101  :  61  |       -(10101101)+1 => -46
		//  
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(~a);
		

	}
	public void method6() {
		// 시프트 연산자
		// >> <<
		// 빠름
		int a = 12;
		// 1100>>2 = 000011
		// 1100<<2 = 110000
		System.out.println(a>>2);
		System.out.println(a<<2);
	}
}
