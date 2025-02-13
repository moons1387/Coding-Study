package kr.or.ddit.study02.sec03;

public class TypeChange2 {
	public static void main(String[] args) {
		int kor = 90;
		int eng = 86;
		int math = 80;

		// 총점과 평균을 출력하시오

		int sum = kor + eng + math;
		double ave = (double) sum / 3; // int 에서 double로 변환
		double ave1 = sum / 3.0; // double로 변환

		System.out.println("총점은 " + sum + "평균은 " + ave1 + "(" + ave + ")");
	}
}
