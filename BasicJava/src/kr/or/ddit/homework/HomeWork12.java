package kr.or.ddit.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork12 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork12 obj = new HomeWork12();
		obj.process();
	}

	public void process() {
		// 로또 범위를 1~8로 바꾸고 당첨을 확인
		int money = 100000;
		boolean flag = true;
		while (flag) { 
			System.out.println("구매할 로또 금액 입력");
			int buy = sc.nextInt();
			if(buy>money) {
				System.out.println("돈이 충분하지 않습니다.");
				continue;
			}
			money = money - buy;
			int wCnt = checkLotto(buy);
			System.out.println(wCnt + "회 당첨되었습니다. \n당첨금 : " + wCnt * 30000 + "원");
			int earn = wCnt * 30000;
			money = money + earn;
			System.out.println("현재 : " + money + "원");
			if (money == 0 || money >= 1000000)
				flag = false;

		}
		// 구매한 로또와 winning 번호를 비교 값이 같다면
		// 3만원 성공
		// money가 100만원을 넘거나 0원이 되면 종료
	}

	public int checkLotto(int buy) {
		int[] winning = generateLotto();
		int[][][] bundle = lottoBundle(buy);
		printBundle(bundle);
		printWinning(winning);
		int wCnt = 0;
		for (int i = 0; i < bundle.length; i++) {
			for (int j = 0; j < bundle[i].length; j++) {
				int o = 0;
				for (int t = 0; t < bundle[i][j].length; t++) {
					if (winning[t] == bundle[i][j][t])
						o++;
					if (o == 6)
						wCnt++;
				}
			}
		}
		return wCnt;
	}

	public void printBundle(int[][][] bundle) {
		for (int[][] paper : bundle) {
			System.out.println("==================");
			for (int[] lotto : paper) {
				System.out.println(array2String(lotto));
			}
			System.out.println("==================");
		}
	}

	public void printWinning(int[] winning) {
		System.out.println("=====당첨번호=====");
		System.out.println(array2String(winning));
		System.out.println("=====당첨번호=====");
	}

	public int[][][] lottoBundle(int money) {

		int papers = money / 5000;
		if (money % 5000 != 0)
			papers++;
		int[][][] bundle = new int[papers][5][6];
		for (int i = 0; i < bundle.length; i++) {
			bundle[i] = lottoPaper();
		}
		if (money % 5000 != 0) {
			bundle[bundle.length - 1] = lottoPaper((money % 5000) / 1000);
		}
		return bundle;
	}

	public int[][] lottoPaper(int num) {
		int[][] paper = new int[num][6];
		for (int p = 0; p < paper.length; p++) {
			paper[p] = generateLotto();

		}
		return paper;
	}

	public int[][] lottoPaper() {
		return lottoPaper(5);
	}

	public int[] generateLotto() {
		int[] lotto = new int[6];

		for (int i = 0; i < 6; i++) {
			int ran = new Random().nextInt(8) + 1;
			lotto[i] = ran;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == ran) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}

	public String array2String(int[] arr) {
		String result = "(";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
			if (i != arr.length - 1) {
				result += ", ";
			}
		}
		result += ")";
		return result;
	}

}