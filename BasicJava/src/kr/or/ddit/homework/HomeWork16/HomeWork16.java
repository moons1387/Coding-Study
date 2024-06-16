package kr.or.ddit.homework.HomeWork16;

import java.util.Scanner;

public class HomeWork16 {
	public static int money = 100000;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork16 obj = new HomeWork16();
		obj.process();
	}

	public void process() {
		boolean flag = Stage.totalMoney();
		while(flag) {
			System.out.println("현재 금액 " + HomeWork16.money);
			System.out.println("1. Stage A");
			System.out.println("2. Stage B");
			System.out.println("3. Stage C");
			
			int sel = sc.nextInt();
			Stage stage = null; 
			if(sel==1) stage = new StageA();
			if(sel==2) stage = new StageB();
			if(sel==3) stage = new StageC();
			if(sel!=1 && sel!=2 && sel!=3) continue;
			stage.game();
			flag = Stage.totalMoney();
		}
	}
}
