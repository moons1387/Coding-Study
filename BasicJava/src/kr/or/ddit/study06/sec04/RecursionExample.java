package kr.or.ddit.study06.sec04;

import java.util.Date;
import java.util.Scanner;

public class RecursionExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		RecursionExample obj = new RecursionExample();
		obj.process();

	}

	public void process() {
//		method(5);
//		System.out.println(add(5));
//		long time = time(5);
//		System.out.println(time);
//		Date d1 = new Date();
//		long fibo = fibo(50);
//		Date d2 = new Date();
//		System.out.println(d2.getTime() - d1.getTime());
//		System.out.println(fibo);
		Date d3 = new Date();
		long fibo2 = fibo2(100);
		Date d4 = new Date();
		System.out.println(d4.getTime() - d3.getTime());
		System.out.println(fibo2);
	}
	
	long[] fiboList = new long[3000];

	public long fibo2(int num) {
		if (num == 2) return 2;
		if (num == 1) return 1;
		if(fiboList[num]!=0) {
			return fiboList[num];
		}
		long result = fibo2(num-1) + fibo2(num-2);
		fiboList[num] = result;
		return result;
	}

	// 피보나치수열
	// 1 2 3 5 8 13 21 34
	public long fibo(int num) {
		if (num == 2)
			return 2;
		if (num == 1)
			return 1;
		return fibo(num - 1) + fibo(num - 2);
	}

	// 5 -> 5*4*3*2*1
	public long time(int num) {
		if (num == 1)
			return 1;
		return num * time(num - 1);
	}

	// 5 -> 5+4+3+2+1
	public int add(int num) {
		if (num == 1)
			return 1;
		return num + add(num - 1);
	}

	public void method(int num) {
		System.out.println(num);
		if (num > 0) {
			method(num - 1);
		}
	}
}
