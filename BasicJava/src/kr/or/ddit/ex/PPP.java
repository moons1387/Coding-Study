package kr.or.ddit.ex;

import java.util.Scanner;

public class PPP {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PPP obj = new PPP();
		obj.process();

	}

	public void process() {
		method1();

	}
	public void method1() {
			int t = 275%60/10 * 600;
			System.out.println(t);
		}
}
