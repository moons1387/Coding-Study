package kr.or.ddit.homework.HomeWork16;

import java.util.Scanner;

public class StageC extends Stage {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StageC obj = new StageC();
		obj.process();

	}

	public void process() {
		game();
	}

	@Override
	public void game() {
		System.out.println("주사위 맞추기 게임");
		System.out.println("1 ~ 6까지 숫자중 하나를 입력하세요.\n7=종료");
		boolean flag = totalMoney();
		while (flag) {
			int sel = sc.nextInt();
			if (sel < 0 || sel > 7) {
				System.out.println("1 ~ 6 또는 7-종료");
				continue;
			}
			int num = (int) (Math.random() * 6 + 1);
			if (sel == 7)
				break;
			if (sel == num) {
				System.out.println("주사위 : " + num + "\t 선택 : " + sel + " 성공");
				winMoney();
			} else {
				System.out.println("주사위 : " + num + "\t 선택 : " + sel + " 실패");
				looseMoney();
			}
			flag = totalMoney();
		}
	}

	@Override
	public void winMoney() {
		HomeWork16.money += 100000;
		System.out.println("현재 금액 " + HomeWork16.money);

	}

	@Override
	public void looseMoney() {
		HomeWork16.money -= 10000;
		System.out.println("현재 금액 " + HomeWork16.money);

	}
}
