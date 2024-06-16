package kr.or.ddit.study03;

import java.util.Scanner;

public class TrinomialOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TrinomialOperator obj = new TrinomialOperator();
		obj.process();

	}

	public void process() {
		method1();
	}

	public void method1() {
		// 삼항연산자 : 3개의 피연산자(x(조건) ? y(true) : z(false))를 필요로 하는 연산
		// ? : 앞의 조건식의 결과에 따라 콜론 앞뒤의
		// : 피연산자가 선택됨.(조건 연산식이라고도 함)
//
//		String str = true ? "참" : "거짓";
//		System.out.println(str);
//		출력 : 참
//
// 		삼항연산자를 이용해서 18세 이상이면 성년 아니면 미성년자를 저장하시오
//		System.out.print("나이를 입력 하세요 : ");
//		int age = sc.nextInt();
//		String adult = age >= 18 ? "성년" : "미성년";
//		System.out.println(adult);

		System.out.print("숫자를 입력 하세요 : ");
		int a = sc.nextInt();
		System.out.print("숫자를 입력 하세요 : ");
		int b = sc.nextInt();
		// a 값이 짝수라면 a+b, 홀수라면 a*b
		int result = a % 2 == 0 ? a + b : a * b;
		System.out.println(a + ", " + b + " =>" + result);
	}
}
