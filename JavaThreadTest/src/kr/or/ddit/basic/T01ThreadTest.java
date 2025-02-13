package kr.or.ddit.basic;

import java.util.Iterator;

/**
 * 싱글 스레드 프로그램 예제
 * @author PC-18
 */

public class T01ThreadTest {
	public static void main(String[] args) {
		// 싱글 스레드 프로그램
//		for (int i = 1; i <= 200; i++) {
//			System.out.print("*");
//		}
//		System.out.println();
//		
//		for(int i = 1; i <= 200; i++) {
//			System.out.print("$");
//		}
		
		long sum = 0;
		for(int i = 1; i <= 100000000; i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		
	}
}
