package kr.or.ddit.study02.sec03;

public class TypeChange5 {
	public static void main(String[] args) {
		// 소수점 버림

		double d = 10.1231;

		// 소수점 한 자리
		int i1 = (int) (d * 10);
		double d10 = i1 / 10.0;
		double d1 = (double) ((int) (d * 10)) / 10;
		System.out.println(d1);
		System.out.println(d10);

		// 소수점 두 자리
		int i2 = (int) (d * 100);
		double d2 = i2 / 100.0;
		System.out.println(d2);
		double d20 = (double) ((int) (d * 100)) / 100;
		System.out.println(d20);
		double d200 = (int)(d*100)/100.0;
		System.out.println(d200);
	}

}
