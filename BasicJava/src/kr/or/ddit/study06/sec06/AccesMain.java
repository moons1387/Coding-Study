package kr.or.ddit.study06.sec06;

public class AccesMain {
	public static void main(String[] args) {
		AccesPrivate ap = new AccesPrivate();
		
		AccesDefault ad = new AccesDefault();
		int a = ad.a;
		ad.defaultMethod1();
		
		AccesProtect ap2 = new AccesProtect();
		int a2 = ap2.a;
	}
}
