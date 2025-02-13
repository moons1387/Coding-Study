package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class SwitchExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample obj = new SwitchExample();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
	}

	public void method1() {
		int select = 1;
		switch (select) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		}
	}

	public void method2() {
		// 월을 입력 받고 마지막 일을 출력하시오.
		// 1,3,5,7,8,10,12 = 31일
		// 4,6,9,11 = 30일
		// 2 = 28일 또는 29일
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
//		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
//			month = (int) (1);
//		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
//			month = (int) (2);
//		} else if (month == 2) {
//			month = (int) (3);
//		}
//		switch (month) {
//		case 1:
//			System.out.println("마지막 일 : 31일");
//			break;
//		case 2:
//			System.out.println("마지막 일 : 30일");
//			break;
//		case 3:
//			System.out.println("마지막 일 : 28일 또는 29일");
//			break; 
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("마지막 일 : 31일");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("마지막 일 : 30일");
			break;
		case 2:
			System.out.println("마지막 일 : 28일 또는 29일");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}

	}

	public void method3() {
		// KOR, ENG, CHN, => 각각 한국, 영국, 중국
		System.out.println("약자 입력");
		String str = sc.next();
		switch (str) {
		case "KOR":
			System.out.println("한국");
			break;
		case "ENG":
			System.out.println("영국");
			break;
		case "CHN":
			System.out.println("중국");
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

	public void method4() {
		// 100 ~ 90 A
		// 90 ~ 80 B
		// 80 ~ 70 C
		// 70 ~ 60 D
		// 60 ~ 0 F
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt() / 10;
		switch (score) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("F 학점");
			break;
		case 6:
			System.out.println("D 학점");
			break;
		case 7:
			System.out.println("C 학점");
			break;
		case 8:
			System.out.println("B 학점");
			break;
		case 9:
		case 10:
			System.out.println("A 학점");
			break;
		// 잘 사용하지 않음.
		}

	}

	public void method5() {
		System.out.println("학점을 입력하세요");
		int score = sc.nextInt();
		String grade = "";
		switch (score / 10) {
		case 10:
			grade = "A+";
			break;
		case 9:
			grade = "A";
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				grade += "-";
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				grade += "0";
				break;
			case 7:
			case 8:
			case 9:
				grade += "+";
				break;
			}
			System.out.println(grade);

		case 8:
			grade = "B";
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				grade += "-";
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				grade += "0";
				break;
			case 7:
			case 8:
			case 9:
				grade += "+";
				break;
			}
			System.out.println(grade);

		case 7:
			grade = "C";
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				grade += "-";
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				grade += "0";
				break;
			case 7:
			case 8:
			case 9:
				grade += "+";
				break;
			}
			System.out.println(grade);

		case 6:
			grade = "D";
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				grade += "-";
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				grade += "0";
				break;
			case 7:
			case 8:
			case 9:
				grade += "+";
				break;
			}
		case 5:
			grade = "F";
			break;
		}
		System.out.println(grade);

	}
}