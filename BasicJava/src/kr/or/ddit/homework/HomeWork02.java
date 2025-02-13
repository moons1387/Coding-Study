package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork02 obj = new HomeWork02();
//		obj.method1();
//		obj.mehtod2();
//		obj.mehtod3();
//		obj.mehtod4();
		obj.mehtod5();
	}
	
	public void method1() {
		/*
		 *  스캐너를 통해서 문자(실수)를 입력 받고.
		 *  소수점 2째 짜리에서 버림  
		 *  ex ) 12.23123 - > 12.23
		 */
		System.out.println("실수 를 입력해주세요.");
		String str = sc.next();
		double num = Double.parseDouble(str);
		int i1 = (int)(num*100);
		double d1 = i1/100.0;
		System.out.println(d1);
		
	}
	
	public void mehtod2() {
		/*
		 *  스캐너를 통해서 대문자를 입력 받고 소문자로 변환 
		 *  ex) A-> a  
		 */
		System.out.println("대문자를 입력 해주세요.");
		String s = sc.next();
		char ch1 = s.charAt(0);
		int i1 = ch1+32;
		char ch2 = (char)(i1);
		System.out.println("소문자 변환 : " + ch2);
		
//		System.out.println("대문자를 입력 해주세요.");
//		String s = sc.next();
//		char ch1 = (char)(s.charAt(0)+32);
//		System.out.println("소문자 변환 : " + ch1);

		
	}
	public void mehtod3() {
		/*
		 *  스캐너를 통해서 소문자를 입력 받고 대문자로 변환 
		 *  ex) f-> F  
		 */
		System.out.println("소문자를 입력 해주세요.");
		String s = sc.next();
		char ch1 = s.charAt(0);
		int i1 = ch1-32;
		char ch2 = (char)(i1);
		System.out.println("대문자 변환 : " + ch2);
		
//		System.out.println("대문자를 입력 해주세요.");
//		String s = sc.next();
//		char ch1 = (char)(s.charAt(0)-32);
//		System.out.println("소문자 변환 : " + ch1);
		
	}
	
	public void mehtod4() {
		/*
		 *  스캐너를 통해서 숫자 3자리를 입력 받고 각 자리수의 합을 구하시오
		 *  ex) 123 -> 1+2+3
		 */
		System.out.println("세자리 숫자를 입력해주세요.");
		String s = sc.next();
		int num = Integer.parseInt(s);
		int i1 = num/100;
		int i2 = (num-(i1*100))/10;
		int i3 = num-(i1*100+i2*10);
		System.out.println("모든 숫자 의 합 = "+(i1+i2+i3)); 
//		char c1 = s.charAt(0);
//		char c2 = s.charAt(1);
//		char c3 = s.charAt(2);
//		int i1 = c1-'0';
//		int i2 = c2-'0';
//		int i3 = c3-'0';
//		System.out.println(i1+i2+i3);
		
	}
	
	public void mehtod5() {
		/*
		 *  스캐너를 통해서 문자(실수)를 입력 받고.
		 *  소수점 2째 짜리에서 반올림  
		 *  ex ) 12.2623 - > 12.3
		 */
		System.out.println("실수를 입력해 주세요.");
		String s = sc.next();
		double d1 = Double.parseDouble(s);
		double d2 = d1*10;
		int i1 = (int)(d1*10);
		double d3 = d2-i1;
		double d4 = d3*2;
		double D = (int)(i1+d4)/10.0;
		System.out.println("소수점 2째 자리 반올림 결과 : "+D);
		
//		int numInt = (int)num;
//		int numRound = numInt+(int)((num-numInt)*2);
//		System.out.println(numRound);
// 		또는 0.05 더하기
		
	}
	
	
}
 