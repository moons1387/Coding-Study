package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample01 obj = new ArrayExample01();
		obj.process();

	}

	public void process() {
//		method1();
		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();

	}

	public void method1() {
		// 변수 5개 만들고 각각 0~100 사이 값을 넣을것.
		int a1 = 11;
		int a2 = 22;
		int a3 = 33;
		int a4 = 44;
		int a5 = 55;

		// 총합 구하기
		int sum = a1 + a2 + a3 + a4 + a5;
		System.out.println(sum);
	}

	public void method2() {
		// int[] students = new int[5];
		// int[] <- 1차원 배열
		// students <- 배열이름(변수)
		// new int[배열크기]; <- 배열생성
		int[] students = new int[5];
		students[0] = 11;
		students[1] = 22;
		students[2] = 33;
		students[3] = 44;
		students[4] = 55;
		int sum = 0;
		for(int i = 0;i<100;i++) {
			int ran = (int)(Math.random()*5);
			int g = students[0];
			students[0] = students[ran];
			students[ran] = g;
		}
		int ran = (int)(Math.random()*5+1);
			System.out.println(students[ran]);
		
	}

	public void method3() {
		// 크기가 3짜리 배열을 만들고 3개의 값을 입력해보세요.

		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		for (int i = 0; i <= array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public void method4() {
//		int a;
//		a = 10;
//		int[] array = new int[3];
//		array[0] = 1;
//		array[1] = 2;
//		array[2] = 3;

//		int b = 10;
		int[] array = { 1, 2, 3, 4, 5 };
//		for (int i = 0; i <= array.length; i++) {
//			System.out.println(array[i]);
//		}
		// 역순으로 출력 = 5 4 3 2 1
		for (int i = 4; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}

	public void method5() {
		int a = 10;
		int b = 7;
		// a 값과 b 값을 바꿔보기
		int c = a;
		a = b;
		b = c;
		System.out.println("a" + "=" + a + " , " + "b" + "=" + b);
	}

	public void method6() {
		int[] score = { 80, 90, 87, 60, 94 };
		// 최대값 구하기
//		int max = 80;
		int max = Integer.MIN_VALUE;
//		int min = 80;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < score.length; i++) {
			if (max < score[i]) {
				max = score[i];
			}
		}
		System.out.println("최대값은 : " + max);

		// 최소값 구하기
		for (int j = 0; j < score.length; j++) {
			if (min > score[j]) {
				min = score[j];
			}
		}
		System.out.println("최소값은 : " + min);
	}

	public void method7() {
		// 거스름돈을 입력 받아 화폐 단위별로 개수를 구하세요.
		// ex) 77650 > 10000원 7장, 1000원 7장, 500원 1개, 100원 1개 50원 1개
		System.out.print("거스름돈을 입력하세요 : ");
		int[] coin = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		int C = sc.nextInt();
		int c = 0;
		for (int i = 0; i <= coin.length; i++) {
			c = C / coin[i];
			C = C - c * coin[i];
			if(c==0) continue;
			System.out.println(coin[i] + "원" + c + "개" + "\t");
		}
	}
}
