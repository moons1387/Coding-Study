package kr.or.ddit.study06.sec02;

public class TriangleExample {
	public static void main(String[] args) {
		
		Point p1 = new Point();
		p1.x = 0;
		p1.y = 0;
		Point p2 = new Point();
		p2.x = 10;
		p2.y = 0;
		Point p3 = new Point();
		p3.x = 10;
		p3.y = 10;
				
		Triangle t1 = new Triangle();
		t1.p1 = p1;
		t1.p2 = p2;
		t1.p3 = p3;
		
		System.out.println(t1);
		
		// t1 p2 y 값은
		System.out.println(t1.p3.x);
		System.out.println(t1.p2.y);
		
	}
}
