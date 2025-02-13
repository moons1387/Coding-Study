package kr.or.ddit.study02.sec04;

// import - 필요한 자바의 기능을 추가함 (단축키, Crtl + Shift + O)
import java.util.Scanner;

public class ScanExapmle {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ScanExapmle obj = new ScanExapmle();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
	}

	public void method5() {
		System.out.print("3자리 문자를 입력하세요 : ");
		String word = sc.next();
		// String -> char
		char ch1 = word.charAt(0);
		char ch2 = word.charAt(1);
		char ch3 = word.charAt(2);
		System.out.println("1번째 문자 : " + ch1);
		System.out.println("2번째 문자 : " + ch2);
		System.out.println("3번째 문자 : " + ch3);
	}

	public void method4() {
		System.out.print("달러를 입력하세요. : ");
		String dollor = sc.next();
		double ER = 1350.18;
		double ERwon = Double.parseDouble(dollor) * ER;
		int won = (int) ERwon;
		System.out.println("결과 : " + won + "원");
	}

	public void method3() {
		// 숫자 2개를 입력 받아 두 수를 더하세요
		System.out.print("숫자를 입력하세요 : ");
		String input1 = sc.next();
		System.out.print("숫자를 입력하세요 : ");
		String input2 = sc.next();
		int num3 = Integer.parseInt(input1) + Integer.parseInt(input2);
		System.out.println("더한 값 : " + num3);
	}

	// input 을 int로 바꾼 후 10을 더하세요
	public void method2() {
		System.out.print("숫자를 입력하세요 : ");
		String input = sc.next();
		int num2 = Integer.parseInt(input) + 10;
		System.out.println("입력 값 + 10 = " + num2);

	}

	public void method1() {
		System.out.print("문자를 입력하세요. : ");
		String input = sc.next();
		System.out.println("입력 결과 값. : " + input);
	}
}
