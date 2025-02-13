package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork04 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork04 obj = new HomeWork04();
		obj.process();

	}

	public void process() {
//		0 -> 가위
//		1 -> 바위
//		2 -> 보
//		
//		컴퓨터가 랜덤으로 내는 가위 바위 보랑,
//		내가 입력한 가위 바위 보를 비교해서 승패를 출력하시오
//		if 문 사용
//		ex)컴퓨터:가위, 사람:보, 결과:졌다/이겼다/비겼다.
		System.out.print("0=가위, 1=바위, 2=보 중 한가지 숫자를 고르시오 : ");
		int a = sc.nextInt();
		int b = (int)(Math.random() * 3);
		if (a == b) {
			System.out.println("사람 : " + a + ", 컴퓨터 : " + b + ", 결과 : 비겼습니다.");
		}
		if (a != b) {
			if (a+1==b || b+2==a) {
				System.out.println("사람 : " + a + ", 컴퓨터 : " + b + ", 결과 : 졌습니다.");
			} else {
				System.out.println("사람 : " + a + ", 컴퓨터 : " + b + ", 결과 : 이겼습니다.");
			}
		}
	}
}