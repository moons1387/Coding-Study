package kr.or.ddit.homework.HomeWork16;

import java.util.Scanner;

public class StageB extends Stage {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StageB obj = new StageB();
		obj.process();

	}

	public void process() {
		game();
	}

	@Override
	public void game() {
		System.out.println("가위 바위 보 게임");
		System.out.println("0=가위, 1=바위, 2=보, 3=종료 \r중 한가지 숫자를 고르세요.");
		boolean flag = totalMoney();
		while (flag) {
			int a = sc.nextInt();
			if (a < 0 || a > 3) {
				System.out.println("0~2 또는 3-종료");
				continue;
			}
			int b = (int) (Math.random() * 3);
			if (a == 3)
				break;
			if (a == b) {
				System.out.println("사람 : " + a + ", 컴퓨터 : " + b + "\n결과 : 비겼습니다.");
				looseMoney();
			}
			if (a != b) {
				if (a + 1 == b || b + 2 == a) {
					System.out.println("사람 : " + a + ", 컴퓨터 : " + b + "\n결과 : 졌습니다.");
					looseMoney();
				} else {
					System.out.println("사람 : " + a + ", 컴퓨터 : " + b + "\n결과 : 이겼습니다.");
					winMoney();
				}
			}
			flag = totalMoney();
		}
	}

	@Override
	public void winMoney() {
		HomeWork16.money += 20000;
		System.out.println("현재 금액 " + HomeWork16.money);

	}

	@Override
	public void looseMoney() {
		HomeWork16.money -= 6000;
		System.out.println("현재 금액 " + HomeWork16.money);

	}
}
