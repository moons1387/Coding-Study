package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class HomeWork02 {

	public static void main(String[] args) {
		long baseMoney = 2000000000;
		int price = 1000;
		TreeSet<Integer> lotto1 = new TreeSet<Integer>();
		for (int i = 2; i < 8; i++) {
			lotto1.add(i);
		}
		System.out.println(lotto1);
		List<Integer> lotto1st = new ArrayList<Integer>(lotto1);
		Lotto lotto1stList = new Lotto(lotto1st);
		TreeSet<Integer> lotto2 = new TreeSet<Integer>();
		for (int i = 20; i < 26; i++) {
			lotto2.add(i);
		}
		System.out.println(lotto2);
		List<Integer> lotto2nd = new ArrayList<Integer>(lotto2);
		Lotto lotto2dnList = new Lotto(lotto2nd);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("가진돈 : "+baseMoney);
			if (baseMoney<=999) {
				System.out.println("돈이 없어요.");
				break;
			}
			System.out.println("1. 로또 구입\r2. 프로그램 종료");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("2500원 주세요");
				while (true) {
					int moneyInsert = sc.nextInt();
					if (moneyInsert > baseMoney) {
						System.out.println("충분하지 않아요");
						continue;
					}
					if (moneyInsert < 1000) {
						System.out.println("충분하지 않아요");
						continue;
					} else {
						int cnt = moneyInsert / 1000;
						int returnMoney = moneyInsert % 1000;
						baseMoney -= moneyInsert;
						System.out.println();
						System.out.println();
						System.out.println();
						int winCnt = 0;
						for (int i = 0; i < cnt; i++) {
							TreeSet<Integer> lottoRnd = new TreeSet<Integer>();
							while (lottoRnd.size() < 6) {
								int num = (int) (Math.random() * 45 + 1);
								lottoRnd.add(num);
							}
							List<Integer> list = new ArrayList<Integer>(lottoRnd);
							System.out.println("만들어진 번호 : " + lottoRnd);
							Lotto myLotto = new Lotto(list);
							if (lotto1stList.equals(myLotto) || lotto2dnList.equals(myLotto)) {
								System.out.println("당첨.");
								winCnt++;
								
							} else {
								System.out.println("미당첨.");
							}
						}
						System.out.println("당첨금 : " + (winCnt * 2500));
						baseMoney += (2500*winCnt);
						System.out.println("거스름돈 : " + returnMoney);
						break;
					}
				}
				continue;
			} else
				System.out.println("감사합니다.");
			break;
		}
	}

}

class Lotto {
	int num1;
	int num2;
	int num3;
	int num4;
	int num5;
	int num6;

	public Lotto(List<Integer> list) {
		super();
		num1 = list.get(0);
		num2 = list.get(1);
		num3 = list.get(2);
		num4 = list.get(3);
		num5 = list.get(4);
		num6 = list.get(5);

	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public int getNum6() {
		return num6;
	}

	public void setNum6(int num6) {
		this.num6 = num6;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num1, num2, num3, num4, num5, num6);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lotto other = (Lotto) obj;
		return num1 == other.num1 && num2 == other.num2 && num3 == other.num3 && num4 == other.num4
				&& num5 == other.num5 && num6 == other.num6;
	}

	@Override
	public String toString() {
		return "lotto [num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4=" + num4 + ", num5=" + num5
				+ ", num6=" + num6 + "]";
	}

}
