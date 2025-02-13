package kr.or.ddit.study09;

import java.util.Scanner;

public class ExceptionExample01 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionExample01 obj = new ExceptionExample01();
		obj.process();

	}

	public void process() {
		int a = 10;
		int[] b = {1, 2, 0};
		try {
			System.out.println("출력");
			for(int i=-1; i < 3 ; i ++) {
			double result = a/b[i];
			System.out.println(result);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 벗어남");
		} 
		
		catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("종료");
	}

}
