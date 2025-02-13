package kr.or.ddit.study11;

import java.util.Date;
import java.util.Scanner;

public class StringBufferTest {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBufferTest obj = new StringBufferTest();
		obj.process();

	}

	public void process() {
		Date d1 = new Date();
//		method1(500000);
		method2(1234);
		Date d2 = new Date();
		System.out.println((d2.getTime()-d1.getTime()));
	}
	public void method1(int num) {
		Date d1 = new Date();
			String str = "";
			for(int i = 0 ; i < num ; i ++) {
			str+="a";
			Date d2 = new Date();
			System.out.println((d2.getTime()-d1.getTime()));	
			}		
		}
	
	public void method2(int num) {
			StringBuffer sb = new StringBuffer();
			for(int i = 0 ; i < num ; i ++) {
				sb.append(i+" ");
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
}
