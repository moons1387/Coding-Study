package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork05 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork05 obj = new HomeWork05();
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
//		method8();
//		method9();
//		method10();
//		method11();
	}

	public void method1() {
		/*
		 * * 
		 * ** 
		 * *** 
		 * **** 
		 * . . . 
		 * ***********
		 */
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void method2() {
		/*
		 *     * 
		 *    ** 
		 *   *** 
		 *  **** 
		 * ***** # 힌트 * 앞에 공백 출력하기.
		 */
		System.out.println("숫자를 입력하세요");
		int row = sc.nextInt();
		for(int a = 0; a < row; a++) {
			for(int b = row-1; b>a; b--) {
					System.out.print(" ");
				}
			for(int c = 0; c<=a; c++ ) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void method3() {
		/*
		 * *****
		 *  **** 
		 *   *** 
		 *    ** 
		 *     *
		 */
		System.out.println("숫자를 입력하세요");
		int row = sc.nextInt();
		for(int a = 0; a < row; a++) {
			for(int c = 1; c<=a; c++ ) {
					System.out.print(" ");
				}
			for(int b = row; b>a; b--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void method4() {
		/*
		 * ***** 
		 * **** 
		 * *** 
		 * ** 
		 * *
		 */
		System.out.println("숫자를 입력하세요");
		int row = sc.nextInt();
		for(int a = 0; a < row; a++) {
			for(int b = row; b>a; b--) {
					System.out.print("*");
				}
			for(int c = 0; c<=a; c++ ) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public void method5() {
		/*
		 *     *     
		 *    ***   
		 *   *****  
		 *  ******* 
		 * *********
		 */
		System.out.println("숫자를 입력하세요");
		int row = sc.nextInt();
		for(int a = 0; a<row; a++) {
			for(int b = row-1; b>a; b--) {
				System.out.print(" ");
			}
			for(int c = 0; c<=2*a; c++) {
				System.out.print("*");
			}
			for(int d = row-1; d>a; d--) {
				System.out.print(" ");
			}
		System.out.println();
		}
	}

	public void method6() {
		/*
		 * 
		 * ********* 
		 *  ******* 
		 *   ***** 
		 *    *** 
		 *     *
		 */
		System.out.println("숫자를 입력하세요");
		int row = sc.nextInt();
		for(int a = 0; a<row; a++) {
			for(int b = 1; b<=a; b++ ) {
				System.out.print(" ");
			}
			for(int c = row*2; c>a*2+1; c--) {
				System.out.print("*");
			}
			for(int d = 1; d<=a; d++ ) {
				System.out.print(" ");
			}
		System.out.println();
		}
	}

	public void method7() {
		/*
		 * ******
		 * *    * 
		 * *    * 
		 * *    * 
		 * *    * 
		 * ******
		 */
		System.out.println("숫자를 입력하세요");
		int row = sc.nextInt();
		for(int a = 0; a<row; a++) {
			System.out.print("*");
		}
		System.out.println();
		for(int b = 2; b<row; b++) {
			for(int c = 0; c >= 0; c--) {
				System.out.print("*");
			}
			for(int d = 2; d < row ; d++ ) {
				System.out.print(" ");
			}
			for(int f = 0; f>=0; f--) {
				System.out.println("*");
			}
		}
		for(int e = 0; e<row; e++) {
			System.out.print("*");
	}
}

	public void method8() {
		// 1  2  3  4  5
		// 6  7  8  9  10
		// 11 12 13 14 15
		// 16 17 18 19 20
		// 21 22 23 24 25
		// 출력하기
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		int a = num*num;
		String str;
		for(int i = 1; i<=a; i++) {
			if(i%num==0) {
				str="\n";
			}else {
				str="";
			}
			System.out.print(i+" "+str);	
		}
	}

	public void method9() {
		// 1 6 11 16 21
		// 2 7 .
		// 3
		// 4
		// 5 10   20 25
		// 출력하기
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		int N = n*n;
		for(int a = 1; a<=n; a++) {
			for(int i = a; i<=N; i+=n) {
				System.out.print(i+" ");	
		}
			System.out.println();
			
		}
	}

	public void method10() {
		// 1 10 11 20 21  
		// 2  9	12 19 22   
		// 3  8	13 18 23 
		// 4  7	14 17 24 
		// 5  6 15 16 25 
		// 출력하기
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		for(int h = 1 ; h<=n ; h++) {
			for(int w = 1 ; w<=n ; w++) {
				if(w%2!=0) {
					System.out.print(h+(w-1)*n+" ");
				} else {
					System.out.print(w*n-h+1+" ");
				}
			}
			System.out.println();
		}
	}

	public void method11() {
		// 1  2  3  4  5
//         10          6	
		// 11          15
		// 20          16
		// 21          25
		// 출력하기
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		for(int a = 1; a<=n; a++) {
			if(a%2!=0) {
			for(int b = a*n-(n-1);b<=n*a; b++) {
				System.out.print(b+" ");
				}
			System.out.println();
			} else {
			for(int b = a*n;b>n*(a-1); b--) {
				System.out.print(b+" ");
				}
			System.out.println();
			} 
		}
	}
}			

