package kr.or.ddit.homework;

import java.util.Date;

public class HomeWork01 {
	public static void main(String[] args) {
		Date date = new Date();

		// 기준일로 부터 지난 시간
		long time = date.getTime();
		System.out.println(time);
		long Y = 31536000000l;
		int D = 86400000;
		int H = 3600000;
		int M = 60000;
		int S = 1000;
		
		long y = time/Y;
		long d1 = time/D;
		long d = time/D-y*365;
		long h1 = time/H;
		long h = time/H-d1*24;
		long m1 = time/M;
		long m = time/M-h1*60;
		long s = time/S-m1*60;
				
		// 기준일로 부터 ?년 ?일 ?시 ?분 ?초 지났습니다.
		//time/1000 = 초
		System.out.println("기준일로 부터"+y+"년 "+d+"일 "+h+"시 "+m+"분 "+s+"초 "+"지났습니다.");
	
		
	}

}
