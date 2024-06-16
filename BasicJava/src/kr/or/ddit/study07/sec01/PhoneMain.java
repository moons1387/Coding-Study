package kr.or.ddit.study07.sec01;

import java.util.Scanner;

public class PhoneMain {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PhoneMain obj = new PhoneMain();
		obj.process();

	}

	public void process() {
//		Phone phone = new Phone();
//		phone.tell();
		
//		DmbPhone dmbPhone = new DmbPhone();
//		dmbPhone.dmb();
//		dmbPhone.tell();
		
		IPhone iphone = new IPhone();
		iphone.camera();
		IPhone2 iphone2 = new IPhone2();
		iphone2.camera();
	}
}
