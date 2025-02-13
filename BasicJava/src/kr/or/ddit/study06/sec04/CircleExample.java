package kr.or.ddit.study06.sec04;

public class CircleExample {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		double r = 5;
		double area = c1.area(r);
		System.out.println("넓이 : "+area);
		
		double circumference = c1.circumference(r);
		System.out.println("둘레 : "+circumference);
	}
}
