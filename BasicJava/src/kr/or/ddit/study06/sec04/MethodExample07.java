package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample07 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample07 obj = new MethodExample07();
		obj.process();

	}

	public void process() {
//		test1();
		int test2 = test2();
		System.out.println(test2);
	}

	public void test1() {
		int i = 1;
		if (i == 1) {
			System.out.println("종료");
			return;
		} else {
			System.out.println("234");
		}
	}

	public int test2() {
		int i = 1;
		if (i == 1) {
			return 10;
		} else {
			return 0;
		}
	}
}
