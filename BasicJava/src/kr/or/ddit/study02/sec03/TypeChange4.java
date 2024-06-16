package kr.or.ddit.study02.sec03;

public class TypeChange4 {
	public static void main(String[] args) {
		// Math.random()
		// 0.0 ~ 0.9xxx 난수 반환
		
		double ran1 = Math.random()*10;
		System.out.println(ran1);
		
		// 0 ~ 9 + 1 = 1 ~ 10
		int ran2 = (int)ran1+1;
		System.out.println(ran2);
		
		// 21~30 숫자를 랜덤으로 출력하시오.
		int ran3 = (int)(Math.random()*10)+21;
		System.out.println(ran3);
		
		// 31 ~ 45 숫자를 랜덤으로 출력하시오.
		int ran4 = (int)(Math.random()*15)+31;
		System.out.println("범위 31 ~ 45 - "+ran4);
		
	}

}
