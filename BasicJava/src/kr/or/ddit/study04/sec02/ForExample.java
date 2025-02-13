package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class ForExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample obj = new ForExample();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
		method9();
//		method10();
//		method11();

	}

	public void method1() {
		//
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		int i4 = 4;
		int i5 = 5;
		int sum = i1 + i2 + i3 + i4 + i5;
		System.out.println(sum);

//		for(int i=1; i<=5; i++) {
//		sum2+=i;
//	int i = 1 	<- 초기화 식 : 처음 시작값을 주어줌
//	i<=5 		<- 조건식	  : 조건이 맞으면 실행문을 실행함
//	sum2+=i; 	<- 실행문	
//	i++         <- 증감식     : 실행문이 실행 된 후 초기화식에 증감을 실행함
		int sum2 = 0;
		for (int i = 1; i <= 5; i++) {
			sum2 += i;
		}
		System.out.println("1~5까지 합 : " + sum2);
	}

	public void method2() {
		// 5 ~ 10 까지 합을 구하시오.
		int sum = 0;
		for (int i = 5; i <= 10; i++) {
			sum += i;
		}
		System.out.println("5~10까지의 합 : " + sum);
	}

	public void method3() {
		// 1 ~ 10까지 홀수의 합을 구하시오.
		int sum = 0;
		for (int odd = 1; odd <= 10; odd ++) {
			
		}
		System.out.println(sum);
//		int sum = 0;
//		for (int odd = 1; odd <= 10; odd = +2) {
//			sum += odd;
//		}
//		System.out.println(sum);
	}

	public void method4() {
		// 1 ~ 10 까지 짝수의 합을 구하시오.
		int sum = 0;
		for (int i = 0; i <= 10; i = i + 2) {
			sum += i;
		}
		System.out.println(sum);
	}

	public void method5() {
		// a부터 z 까지 반복문을 이용해 출력하시오.
//		for (int i = 'a'; i < 'a' + 26; i++) {
//			System.out.print((char) i);
//		for (char i = 'a'; i < 'z'; i++) {
//			System.out.print(i);
		for (char i = 'a'; i < 'z'; i++) {
			System.out.print(i);
		}
	}

	public void method6() {
		// 소문자를 입력받고 해장 문자부터 ~ z 까지 출력하시오.
		System.out.print("아무 알파벳 소문자를 입력하세요 : ");
		String a = sc.next();
		char b = a.charAt(0);
		for (; b <= 'z'; b++) {
			System.out.print((char) b);
		}
	}

	public void method7() {
		// 숫자를 입력받고 해당 숫자까지의 총합.
		System.out.println("숫자를 입력하세요 : ");
		int a = sc.nextInt();
		int sum = 0;
		for (int i = a; i > 0; i--) {
			sum += i;
		}
		System.out.println(sum);

//		System.out.println("숫자를 입력하세요 : ");
//		int a = sc.nextInt();
//		int sum = 0;
//		for(int i = 1; i<=a; i++) {
//			sum+=i;
//		}
//		System.out.println(sum);
	}

	public void method8() {
		// 문자열 다음줄로 출력하기
		System.out.println("단어를 입력하세요");
		String word = sc.next();
		for (int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
	}

	public void method9() {
		// 문자열 거꾸로 출력하기
		System.out.println("문자열을 입력하세요");
		String word = sc.next();
		for (int i = word.length() - 1; i >= 0; i--) {
			System.out.print(word.charAt(i));
//		System.out.println("문자열을 입력하세요");
//		String word = sc.next();
//		for(int i=word.length()-1; i>=0; i--) {
//			System.out.print(word.charAt(word.length()-1-i));
		}
	}

	public void method10() {
		// 영어를 입력하고 모음을 제거하시오.
		// ex) abcde - abcd
		// 모음 a e i o u
		System.out.println("영어 단어를 입력하세요");
		String word = sc.next();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u') {
			} else {
				System.out.print(word.charAt(i));
			}
		}

	}

	public void method11() {
		// for 문을 이용해서 문자를 입력받고 숫자를 제거하시오.
		System.out.println("문자와 숫자를 입력하세요");
		String word = sc.next();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch >= '0' && ch <= '9') {
			} else {
				System.out.print(ch);
			}
		}
	}
}
