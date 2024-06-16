package kr.or.ddit.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HomeWork18 {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		HomeWork18 hw = new HomeWork18();
		hw.process();
	}

	public void process() {
		System.out.println("주사위를 몇번 던질까요?");
		long num = sc.nextLong();
		printHistoGram(num);

	}

	public int oneDice() {
		int a = new Random().nextInt(6) + 1;
		return a;
	}

	public int twoDice() {
		int b = new Random().nextInt(6) + 1;
		return b;
	}

	public Map trialNtimes(long n) {
		Map<Integer, Integer> sumTable = new HashMap();
		int sum;
		for (int i = 2; i <= 12; i++) {
			sumTable.put(i, 0);
		}
		for (int i = 0; i < n; i++) {
			sum = oneDice() + twoDice();
			sumTable.put(sum, sumTable.get(sum) + 1);
		}
//		int cnt = 1;
//		if(sumTable.containsKey(sum)) cnt+=sumTable.get(sum);
//		sumTable.put(sum, cnt);
		return sumTable;
	}

	public void printHistoGram(long num) {
		Map<Integer, Integer> resultMap = trialNtimes(num);

		for (int i = 2; i <= 12; i++) {
			long a = resultMap.get(i) * 100 / num;
			System.out.print(i + ": \t");
			for (int j = 0; j < a; j++) {
				System.out.print("■");
			}
			System.out.println();
		}
	}
}
