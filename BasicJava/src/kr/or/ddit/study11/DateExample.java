package kr.or.ddit.study11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DateExample obj = new DateExample();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
		method3();
//		method4();
//		method5();
//		method6();
	}

	public void method1() {
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		System.out.println(time);

		// 몇년 몇월 몇시 몇분 몇초
		int sec = 1000;
		int min = sec * 60;
		int hour = min * 60;
		int day = hour * 24;
		int year = day * 365;
	}

	public void method2() {
		// date -> String
		// date2String

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss:SSSS");
		Date date = new Date();
		String str = sdf.format(date);
		System.out.println(str);

	}

	public void method3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String str = "2024.04.30";
		// String -> Date
		try {
			Date date = sdf.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void method4() {
		// D-day 계산기
		Date sysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String str = sc.next();
		try {
			Date date = sdf.parse(str);
			long now = sysDate.getTime();
			long d = date.getTime();
			long dDay = d - now;
			int sec = 1000;
			int min = sec * 60;
			int hour = min * 60;
			int day = hour * 24;
			int year = day * 365;

			long days = dDay / day;
			dDay %= day;

			long hours = dDay / hour;
			dDay %= hour;

			long mins = dDay / min;
			dDay %= min;

			long secs = dDay / sec;
			dDay %= sec;

			System.out.println(days + " " + hours + " " + mins + " " + secs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void method5() {
		int sec = 1000;
		int min = sec * 60;
		int hour = min * 60;
		int day = hour * 24;
		int year = day * 365;
		System.out.println("더할 날짜를 입력하세요.");
		long a = sc.nextInt();
		long t = a * day;
		Date date = new Date();
		Date date2 = new Date(date.getTime() + t);
		System.out.println(date);
		System.out.println(date2);
	}

	public void method6() {
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 1);
//		cal.set(Calendar.MONTH, 1);
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		Date date = cal.getTime();
		System.out.println(date);
	}
}
