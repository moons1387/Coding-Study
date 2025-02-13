package kr.or.ddit.homework.HomeWork16;

public abstract class Stage {

	abstract void game();

	abstract void winMoney();
	
	abstract void looseMoney();
	
	public static boolean totalMoney() {
		if (HomeWork16.money <= 0) {
			System.out.println("파산!!!!");
			return false;
		}
		if (HomeWork16.money >= 200000) {
			System.out.println("게임 정복");
			return false;
		}
		return true;
	}
}
