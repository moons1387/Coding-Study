package kr.or.ddit.study02.sec02;

public class CharExample {
	public static void main(String[] args) {
		// char : 부호 없는 2byte 정수 0~65535
		// 		    문자 표현을 위해 사용됨, 숫자 문자 1:1로 표현
		
		char c1 = 65;
		System.out.println(c1);
		
		char c2 = 'B';
		System.out.println(c2);
		
		char c3 = 'B'+32;
		System.out.println(c3);
		
		char c4 = 'B'+1;
		System.out.println(c4);
		
		char c5 = '가';
		System.out.println(c5);
		
		int i5 = c5;
		System.out.println(i5);
	
	}

}
