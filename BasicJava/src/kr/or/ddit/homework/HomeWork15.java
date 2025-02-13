package kr.or.ddit.homework;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HomeWork15 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork15 obj = new HomeWork15();
		obj.process();

	}

	public void process() {
		Calendar cal = Calendar.getInstance();
		while (true) {
			// <이전달 다음달>
			cal.set(Calendar.DATE, 1);
			int firstDay = cal.get(Calendar.DAY_OF_WEEK);
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			System.out.println(firstDay);
			System.out.println(month);
			System.out.println(year);


			// 이번달의 마지막 일
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println();
			System.out.println("< 이전달 ---------- " + year + "년 " + month + "월 ----------- 다음달 >");
			System.out.println();
			System.out.println("일 \t월 \t화 \t수 \t목 \t금 \t토");
			for (int i = 1; i < firstDay; i++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= lastDay; j++) {
				if ((j + firstDay - 2) % 7 == 0) {
					System.out.print("\n" + j + "\t");
				} else {
					System.out.print(j + "\t");
				}

			}
			System.out.println();
			String str = sc.next();
			if (str.equals(">")) {
				cal.add(Calendar.MONTH, 1);
			} else if (str.equals("<")) {
				cal.add(Calendar.MONTH, -1);
			}
		}
	}
}
