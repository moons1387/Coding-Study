package kr.or.ddit.study06.sec04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Lotto obj = new Lotto();
		obj.process();

	}

	public void process() {
		int[][][] bundle = lottoBundle(12000);
		printBundle(bundle);

	}

	public void printBundle(int[][][] bundle) {
		for (int[][] paper : bundle) {
			System.out.println("====================");
			for (int[] lotto : paper) {
				System.out.println(array2String(lotto));
			}
			System.out.println("====================");
		}
	}

	public int[][][] lottoBundle(int money) {
		int papers = money / 5000;
		if (papers % 5000 != 0)
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
			int ran = new Random().nextInt(45) + 1;
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
		String result = "[";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
			if (i != arr.length - 1)
				result += ", ";
		}
		result += "]";
		return result;
	}
}
