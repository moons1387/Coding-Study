package kr.or.ddit.homework.HomeWork16;

import java.util.Scanner;

public class StageA extends Stage {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StageA obj = new StageA();
		obj.process();

	}

	public void process() {
		game();
	}

	@Override
	public void game() {
		System.out.println("홀짝 게임");
		System.out.println("범위는 1 ~ 10 까지");
		System.out.println("1=홀, 2=짝, 3=종료 \n셋중 하나를 고르세요.");
		boolean flag = totalMoney();
		while (flag) {
			int sel = sc.nextInt();
			if (sel <= 0 || sel > 3) {
				System.out.println("1~2 또는 3-종료");
				continue;
			}
			int num = (int) (Math.random() * 10 + 1);
			if (num % 2 == 0 && sel == 1) {
				System.out.println(num + "은 짝수입니다. \n실패");
				looseMoney();
			} else if (num % 2 == 0 && sel == 2) {
				System.out.println(num + "은 짝수입니다. \n성공");
				winMoney();
			} else if (num % 2 != 0 && sel == 1) {
				System.out.println(num + "은 홀수입니다. \n성공");
				winMoney();
			} else if (num % 2 != 0 && sel == 2) {
				System.out.println(num + "은 홀수입니다. \n실패");
				looseMoney();
			} else
				break;
			flag = totalMoney();
		}
	}

	@Override
	public void winMoney() {
		HomeWork16.money += 4000;
		System.out.println("현재 금액 " + HomeWork16.money);

	}

	@Override
	public void looseMoney() {
		HomeWork16.money -= 2000;
		System.out.println("현재 금액 " + HomeWork16.money);

	}

}
