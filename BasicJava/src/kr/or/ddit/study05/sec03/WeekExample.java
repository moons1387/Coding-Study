package kr.or.ddit.study05.sec03;

import java.util.Scanner;

/**
 * @since 2024.04.23
 * @author PC-18
 * @version 1.0(최초 생성)
 *
 */
public class WeekExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WeekExample obj = new WeekExample();
		obj.process();

	}

	public void process() {
		week(3);
		week(Week.SAT);
		
	}
	public void week(Week week) {
//		if (week == Week.SUN) {
//			System.out.println("일요일");
//		}
//		if (week == Week.MON) {
//			System.out.println("월요일");
//		}
//		if (week == Week.TUE) {
//			System.out.println("화요일");
//		}
//		if (week == Week.WED) {
//			System.out.println("수요일");
//		}
//		if (week == Week.THD) {
//			System.out.println("목요일");
//		}
//		if (week == Week.FRI) {
//			System.out.println("금요일");
//		}
//		if (week == Week.SAT) {
//			System.out.println("토요일");
//		}
		System.out.println(week.day);
		}

	/**
	 * @author PC-18 num 1 = 일요일, 2 = 월요일, ..., 7 = 일요일.
	 *
	 */
	public void week(int num) {
		if (num == 1) {
			System.out.println("일요일");
		}
		if (num == 2) {
			System.out.println("월요일");
		}
		if (num == 3) {
			System.out.println("화요일");
		}
		if (num == 4) {
			System.out.println("수요일");
		}
		if (num == 5) {
			System.out.println("목요일");
		}
		if (num == 6) {
			System.out.println("금요일");
		}
		if (num == 7) {
			System.out.println("토요일");
		}
	}
}
