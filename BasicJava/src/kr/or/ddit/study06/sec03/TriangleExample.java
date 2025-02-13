package kr.or.ddit.study06.sec03;

import java.util.Random;

public class TriangleExample {
	public static void main(String[] args) {
//		Point p1 = new Point(0, 0);
//		Point p2 = new Point(3, 0);
//		new Point(0, 3);
//		  int ran = new Random().nextInt(10);

		Point p1 = new Point(0, 0);
		Triangle t1 = new Triangle(p1, new Point(10, 0), new Point(0, 10));
		System.out.println(t1);
		System.out.println(t1.area);
		Triangle t2 = new Triangle(0, 0, 10, 0, 0, 10);
		System.out.println(t2);
		System.out.println(t2.area);
	}
}
