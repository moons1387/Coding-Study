package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample06 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample06 obj = new MethodExample06();
		obj.process();

	}

	public void process() {
		int[] arr = { 1, 2, 3 };
		method1(arr);
		
//		method2(arr);
		method2(1, 3, 5, 7);

	}

	public void method1(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}
	public void method2(int... arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
