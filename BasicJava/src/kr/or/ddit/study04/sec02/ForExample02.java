package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class ForExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample02 obj = new ForExample02();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
		method4();
//		method5();
//		method6();

	}
	public void method1() {
		//	continue 문 : 해당 루프를 종료시키 다음 루프로 바로 진행
		for(int i=0;i<10;i++) {
			if(i%2==0) continue;
			System.out.println(i);
		}
		
	}
	public void method2() {
		// 영어를 입력하고 모음을 제거하시오.
		System.out.println("영어 단어를 입력하세요");
		String str = sc.next();
		int w = str.length();
		for(int a = 0; a<w; a++) {
			char c = str.charAt(a);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') continue;
			System.out.print(c);
		}
	}
	public void method3() {
		// break 문
		// 반복문을 종료한다.
		for(char ch = 'a'; ch<='z'; ch++) {
			if(ch=='o') break;
			System.out.print(ch);
			
		}
	}
	public void method4() {
		boolean flag = true;
		for(int i=0; i<100; i++) {
			for(int j=0 ; j<100; j++) {
				if(flag) {
				System.out.println(i+", "+j);
			}
				if(i==30 && j==30) flag = false;
			}
		}
		
	}
	public void method5() {
		// 라벨(원하는 대로 작성가능) : 라벨을 적용한 부분을 종료한다.
		END:
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				System.out.println(i+", "+j);
				if(i==30 && j==30) {
					break END;
				}
				}
			}
		}
	public void method6() {
		// 구구단 출력
		System.out.println("숫자 한가지를 입력하세요 : ");
		for(int a = 1;a<=9;a++) {
			System.out.println("========="+a+"단"+"=========");
			for(int i = 1; i<=9; i++) 
			{
			System.out.println(i+" * "+a+" = "+a*i);
			}
		System.out.println();
		}
	}
}
