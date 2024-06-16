package kr.or.ddit.study06.sec06.Acces;

import kr.or.ddit.study06.sec06.AccesDefault;
import kr.or.ddit.study06.sec06.AccesPrivate;
import kr.or.ddit.study06.sec06.AccesProtect;
import kr.or.ddit.study06.sec06.AccesPublic;

public class AccesMain {
	public static void main(String[] args) {
		AccesPrivate ap = new AccesPrivate();
		
		AccesDefault ad = new AccesDefault();
//		int a = ad.a;
//		ad.defaultmethod1();
		
		AccesProtect ap2 = new AccesProtect();
//		int a2 = ap2.a;
		
		AccesPublic ap3 = new AccesPublic();
		int a3 = ap3.a;
		ap3.publicMethod();

	}
}
