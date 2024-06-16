package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork08 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork08 obj = new HomeWork08();
		obj.process();

	}

	public void process() {
		String[] stuName = { "민준", "서연", "정훈", "성호", "미영", };
		// 국, 영, 수 총점 평균 등수
		int[][] score = {   { 90, 90, 90, 0, 0, 1 },
							{ 60, 60, 60, 0, 0, 1 },
							{ 50, 50, 50, 0, 0, 1 },
							{ 70, 70, 70, 0, 0, 1 }, 
							{ 80, 80, 80, 0, 0, 1 }, 
						};

		// 1. 총점/평균 계산
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length - 3; j++) {
				sum += score[i][j];
				avg = sum / 3;
				score[i][3] = sum;
				score[i][4] = avg;
			}
			sum = 0;
			avg = 0;
		}
		System.out.println("총점 및 평균");
		System.out.println();
		for (int i = 0; i < score.length; i++) {
			System.out.print(stuName[i] + " 총점 평균 = ");
			for (int j = 3; j < score[i].length - 1; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
		// 2. 등수 구하기
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("등수 입력 후 출력");
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[i][4] == score[j][4]) {
					continue;
				} else if (score[i][4] < score[j][4]) {
					score[i][5] += 1;
				}
			}
		}
		System.out.println();

		// 3. 출력
		System.out.println("이름\t국\t영\t수\t총점\t평균\t등수");
		System.out.println("=========================================================");
		for (int i = 0; i < score.length; i++) {
			System.out.print(stuName[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}

		// 4. 정렬후 출력
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("정렬 후 출력");
		System.out.println();

		int[] spare = new int[6];
		String n;
		for (int l = 0; l < score.length; l++) {
			for (int i = 0; i < score.length - 1; i++) {
				for (int j = 0; j < score[i].length; j++) {
					if (score[i][5] > score[i + 1][5]) {
						spare[j] = score[i][j];
						score[i][j] = score[i + 1][j];
						score[i + 1][j] = spare[j];
						if(j==5) {
						n = stuName[i];
						stuName[i] = stuName[i + 1];
						stuName[i + 1] = n;
						}
					}
				}
			}
		}
		System.out.println("이름\t국\t영\t수\t총점\t평균\t등수");
		System.out.println("=========================================================");
		for (int i = 0; i < score.length; i++) {
			System.out.print(stuName[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
