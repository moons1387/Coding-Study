package kr.or.ddit.study02.sec02;

public class FloatExample {
	public static void main(String[] args) {
		// 1. float	   : 4byte (부호 1bit, 지수 8bit, 가수 23bit)
		//				  끝에 f, F 추가
		// 2. double   : 8byte (부호 1bit, 지수 11bit, 가수 52bit)
		//				  실수형 기본 타입
		
		float f1 = 3.14159265f;
		double d1 = 3.14159265;
		
		if(f1==d1) {
			System.out.println("같은 값");
		}else {
			System.out.println("다른 값");
		}
	}
}
