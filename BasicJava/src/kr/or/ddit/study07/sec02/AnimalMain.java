package kr.or.ddit.study07.sec02;

import java.util.Scanner;

public class AnimalMain {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AnimalMain obj = new AnimalMain();
		obj.process();

	}

	public void process() {
		System.out.println("1. 고양이");
		System.out.println("2. 강아지");
		System.out.println("3. 호랑이");
//		while (true) {
//			int sel = sc.nextInt();
//			if (sel == 1) {
//				Cat cat = new Cat();
//				cat.cry();
//			} else if (sel == 2) {
//				Dog dog = new Dog();
//				dog.cry();
//			} else
//				break;
//		}
		int sel = sc.nextInt();
		Animal ani = null;
		if(sel == 1) ani = new Cat();
		if(sel == 2) ani = new Dog();
		if(sel == 3) ani = new Tiger();
		
		ani.cry();
	}
}
