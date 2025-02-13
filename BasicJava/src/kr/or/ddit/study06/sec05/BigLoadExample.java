package kr.or.ddit.study06.sec05;

import java.util.Date;

public class BigLoadExample {
	public static void main(String[] args) {
		
		Date d1 = new Date();
		
		BigLoad b1 = BigLoad.getIntance();
		BigLoad b2 = BigLoad.getIntance();
		BigLoad b3 = BigLoad.getIntance();
//		BigLoad b1 = new BigLoad();
//		BigLoad b2 = new BigLoad();
//		BigLoad b3 = new BigLoad();

		Date d2 = new Date();
		
		System.out.println(d2.getTime() - d1.getTime());
	}
}
