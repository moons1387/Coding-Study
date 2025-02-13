package kr.or.ddit.ddd;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ddd {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ddd obj = new ddd();
		obj.process();
	}

	public void process() {
		// 로또 범위를 1~8로 바꾸고 당첨을 확인
		int money = 100000;
		while (true) {
			System.out.println("구매할 로또 금액 입력");
			int buy = sc.nextInt();
			int[] winning = generateLotto();
			int[][][] bundle = lottoBundle(buy);
			money -= buy;
			// 구매한 로또와 winning 번호를 비교 값이 같다면
			// 10만원 상금
			// money가 100만원을 넘거나 0원이 되면 종료
			for (int i = 0; i < bundle.length; i++) {
				for (int j = 0; j < bundle[i].length; j++) {
					if (Arrays.equals(bundle[i][j], winning)) {
						money += 100000;
					}
				}
			}
			System.out.println("내 돈: " + money);

			if (money >= 1000000 || money == 0) {
				break;
			}
		}
	}

	public void printBundle(int[][][] bundle) {
		for (int[][] paper : bundle) {
			System.out.println("========================");
			for (int[] lotto : paper) {
				System.out.println(array2String(lotto));
			}
			System.out.println("========================");
		}
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
			int ran = new Random().nextInt(7) + 1;
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