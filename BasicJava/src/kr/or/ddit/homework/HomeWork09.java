package kr.or.ddit.homework;

import java.util.Scanner;

class Score {
	// 이름 국영수 총점 평균 등수
	String name;
	int kor;
	int eng;
	int math;
	int sum = 0;
	double avg = 0;
	int rank = 1;

	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg + "\t"
				+ rank;
	}
}

public class HomeWork09 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork09 obj = new HomeWork09();
		obj.process();

	}

	public void process() {
		// 08번 숙제를 클레스로 변경
		Score s1 = new Score();
		s1.name = "민준";
		s1.kor = 88;
		s1.eng = 77;
		s1.math = 88;

		Score s2 = new Score();
		s2.name = "민재";
		s2.kor = 87;
		s2.eng = 76;
		s2.math = 87;

		Score s3 = new Score();
		s3.name = "지훈";
		s3.kor = 99;
		s3.eng = 77;
		s3.math = 88;

		Score s4 = new Score();
		s4.name = "서연";
		s4.kor = 88;
		s4.eng = 99;
		s4.math = 72;

		Score s5 = new Score();
		s5.name = "민서";
		s5.kor = 66;
		s5.eng = 95;
		s5.math = 99;


		Score[] score = { s1, s2, s3, s4, s5 };
		// 1. 총점/평균
		System.out.println("이름\t 국어\t 영어\t 수학\t 총합\t 평균\t 등수");
		System.out.println("======================================================");
		for (int i = 0; i < score.length; i++) {
			score[i].sum = score[i].kor + score[i].eng + score[i].math;
			score[i].avg = (double)((int)(score[i].kor + score[i].eng + score[i].math)*10 / 3)/10;
		}
//		for(Score s: score) {
//			s.sum = s.kor+s.eng+s.math;
//			s.avg = s.sum/3.0;
//		}

		// 2. 등수 구하기
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[i].sum < score[j].sum) {
					score[i].rank += 1;
				} else {
					continue;
				}
			}
		}
		// 3. 출력
		for(int i = 0; i < score.length; i++)
			System.out.println(score[i]);

		// 4. 정렬
		Score s6 = new Score();
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score.length-1; j++) {
				if(score[j].rank>score[j+1].rank) {
				s6 = score[j];
				score[j] = score[j+1];
				score[j+1] = s6;
				}
			}
		}
System.out.println("=========================================================");
		// 5. 출력
		for(int i = 0; i < score.length; i++)
			System.out.println(score[i]);

	}

}
