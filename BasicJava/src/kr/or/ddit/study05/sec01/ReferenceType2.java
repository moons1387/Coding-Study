package kr.or.ddit.study05.sec01;

import java.util.Scanner;

public class ReferenceType2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ReferenceType2 obj = new ReferenceType2();
		obj.process();

	}

	public void process() {
//		method1();
		method2();
	}

	public void method1() {
		int a = 10;
		// 1 - stack
		int b = 15;
		{
			// 2 - stack
			String c = "test";
			// 3 - stack(address), heap(test)
		}
		String d = "test";
		// 4 -c가 stack에서 사라지고 d로 대체됨 heap에 test의 주소와 값은 저장됨
		{
			int e = 4;
			// 5 - stack
			{
				int f = 10;
				// 6 - stack
			}
			// f - stack 제거
			int g = 3;
			// 7 - stack
			d = "test2";
			// 8 d - 의 주소가 heap의 test2의 주소로 변경
		}
	}
	// 모든 stack의 값이 사라지고 heap의 주소와 값은 저장됨

	public void method2() {
		String a = null; // - stack에 a만 저장됨 주소X ... heapX
		if (a == null || a.isEmpty()) {
			System.out.println("빈 문자열");
		}
//
//		위 아래는 다르다.
//
// 		String a=""; // - stack에 a와 주소가 저장되고 heap에 주소만 저장
//		if (a.isEmpty() || a == null) {
//			System.out.println("빈 문자열");
////		                ㄴ "" != null.
//		}
	}
}
