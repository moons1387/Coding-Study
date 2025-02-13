package kr.or.ddit.homework;

import java.net.MulticastSocket;
import java.util.Scanner;

public class HomeWork06 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork06 obj = new HomeWork06();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
//		method3();
		method4();
	}

	public void method1() {
		System.out.println("2~9 까지 중 숫자 한가지를 입력하세요." + "\n종료하시려면 0을 입력하세요.");
		boolean bln1 = true;
		boolean bln2 = true;
		while (bln1) {
			bln2 = true;
			int n = sc.nextInt();
			if (n == 0) {
				bln1 = false;
			} else if (n <= 1) {
				System.out.println("오류 : 1이하. " + "\n2~9 까지 중 숫자 한가지를 입력하세요");
				continue;
			} else if (n <= 9) {
				while (bln2) {
					for (int a = 1; a <= 9; a++) {
						System.out.println(n + "*" + a + " = " + a * n);
						if (a == 9) {
							System.out.println("계속 하시려면 다음 숫자를 입력하시고," + "\n종료하시려면 0을 입력하세요");
							int n1 = sc.nextInt();
							if (n1 < 0 || n1 == 1) {
								System.out.println("오류 : 1이하. " + "\n2~9 까지 중 숫자 한가지를 입력하세요");
								bln2 = false;
							} else if (n1 == 0) {
								bln1 = false;
								bln2 = false;
							} else if (n1 < 10) {
								n = n1;
								break;
							} else {
								System.out.println("오류 : 9초과. " + "\n2~9 까지 중 숫자 한가지를 입력하세요");
								bln2 = false;
							}
						}
					}
				}
			} else {
				System.out.println("오류 : 9초과. " + "\n2~9 까지 중 숫자 한가지를 입력하세요");
				continue;
			}
		}
		System.out.println("구구단을 종료합니다.");
	}

	public void method2() {
		for (int a = 2; a < 10; a++) {
			for (int b = 1; b < 10; b++) {
				System.out.print(a + "X" + b + "=" + a * b + "\t");
			}
			System.out.println();
		}
	}

	public void method3() {
		System.out.println("구구단에서 제외하고 싶은 숫자를 입력하세요.");
		int n = sc.nextInt();
		for (int a = 1; a < 10; a++) {
			for (int b = 2; b < 10; b++) {
				if (b == n)
					continue;
				System.out.print(b + "X" + a + " = " + a * b + "\t");
			}
			System.out.println();
		}
	}

	public void method4() {
		int n = (int) (Math.random() * 100) + 1;
		int s1 = 0;
		int s2 = 0;
		String str = "+";
		if (n % 2 != 0) {
			for(int a = 1;a<=n;a+=2) {
				s1= s1 + a;
				if(a==n) str=" = ";
				System.out.print(a+str);
			}
			System.out.print(s1);
		}
		else {
			for(int a = 2;a<=n;a+=2) {
				s1= s1+ a * a;
				if(a==n) str=" = ";
				System.out.print(a+"^2"+str);
			}
			System.out.print(s1);
		}
	}
}
