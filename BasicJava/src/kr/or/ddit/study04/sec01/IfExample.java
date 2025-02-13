package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class IfExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		IfExample obj = new IfExample();
		obj.process();

	}

	public void process() {
//		method1(); // if 문
//		method2(); // if(){} else{}
//		method3(); // if(){} else if(){} ... else{}
//		method4();
//		method5();
		method6();
	}

	public void method1() {
		if (true) {
			System.out.println("IF안 실행문 ");
		}
		System.out.println("IF밖 실행문 ");

	}

	public void method2() {
		// 점수를 입력 받아 60점 이상이면 합격 아니면 불합격 출력
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();

//		if(score>=60) {
//			System.out.println("합격");
//		}
//		if(score<60) {
//			System.out.println("불합격");
//		}
//		==
		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

	public void method3() {
		// 점수를 입력받고 학점을 출력하세요.
		// 90이상 A, 80이상 B, 70이상 C, 60이상 D, 그 외 F
		System.out.println("점수를 입력 하세요");
		int score = sc.nextInt();
//		
//		if(score>=90) {
//			System.out.println("A 학점");
//		}
//		else {
//			if(score>=80) {
//				System.out.println("B 학점");
//			}
//			else {
//				if(score>=70) {
//					System.out.println("C 학점");
//				}
//				else {
//					if(score>=60) {
//						System.out.println("D 학점");
//					}
//					else {
//						System.out.println("F 학점");
//					}
//				}
//			}
//		}
//		==
//		if(score>=90) {
//			System.out.println("A 학점");
//		}
//		else if(score>=80 && score<90) {
//			System.out.println("B 학점");
//		}
//		if(score>=70 && score<80) {
//			System.out.println("C 학점");
//		}
//		if(score>=60 && score<70) {
//			System.out.println("D 학점");
//		}
//		if(score<60) {
//			System.out.println("F 학점");
//		}
//		==
		if (score >= 90) {
			System.out.println("A 학점");
		} else if (score >= 80) {
			System.out.println("B 학점");
		} else if (score >= 70) {
			System.out.println("C 학점");
		} else if (score >= 60) {
			System.out.println("D 학점");
		} else {
			System.out.println("F 학점");
		}
	}

	public void method4() {
		// 월을 입력 받아 봄(3~5), 여름(6~8), 가을(9~11), 겨울(12~2)을 출력하시오
		System.out.println("월을 입력하세요.");
		int month = sc.nextInt();

		if ((month == 3 || month == 4) || month == 5) {
			// 왼쪽이 참일 경우 오른쪽을 실행하지 않는다.
			System.out.println("봄");
		}
		if (month == 6 || month == 7 || month == 8) {
			System.out.println("여름");
		}
		if (month == 9 || month == 10 || month == 11) {
			System.out.println("가을");
		}
		if (month == 1 || month == 2 || month == 12) {
			System.out.println("겨울");
		}
	}

	public void method5() {
		// 키와 체중을 입력하여 BMI 지수를 구하고
		// BMI 지수에 따른 정상, 과체중, 비만, 고도비만 정보를 출력하시오.
		// BMI 지수 = 체중(kg)/(키(m)*키(m))

		// 18.5 미만 : 저체중
		// 18.5 ~ 22.9 : 정상체중
		// 23.0 ~ 24.9 : 과체중
		// 25.0 ~ 29.9 : 비만
		// 30.0 이상 : 고도비만

		System.out.print("키를 입력하세요(cm) :");
		double height = sc.nextDouble() / 100;
		System.out.print("몸무게를 입력하세요(kg) :");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);
		double BMI = (int) (bmi * 10) / 10.0;

		if (bmi < 18.5) {
			System.out.println("BMI 지수 : " + BMI + " 저체중");
		} else if (bmi >= 18.5 && bmi <= 22.9) {
			System.out.println("BMI 지수 : " + BMI + " 정상체중");
		} else if (bmi >= 23.0 && bmi <= 24.9) {
			System.out.println("BMI 지수 : " + BMI + " 과체중");
		} else if (bmi >= 25.0 && bmi <= 29.9) {
			System.out.println("BMI 지수 : " + BMI + " 비만");
		} else if (bmi >= 30.0) {
			System.out.println("BMI 지수 : " + BMI + " 고도비만");
		}
	}

	public void method6() {
		// 점수를 입력받고 학점을 출력하세요.
		// 90이상 A, 80이상 B, 70이상 C, 60이상 D, 그 외 F 그리고 1의 자리 0~2 -, 3~6 0, 7~9 +
		System.out.print("점수를 입력하세요 :");
		int score = sc.nextInt();
		String grade = "";
		if (score == 100) {
			grade = "A+";
		} else if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		if (score >= 60 && score != 100) {
			if (score % 10 <= 2) {
				grade += "-";
			} else if (score % 10 <= 6) {
				grade += "0";
			} else if (score % 10 <= 9) {
				grade += "+";
			}
		}
		System.out.println(grade);
	}
}
