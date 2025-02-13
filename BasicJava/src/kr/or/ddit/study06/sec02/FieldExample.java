package kr.or.ddit.study06.sec02;

public class FieldExample {
	String name;
	int age;
	
	public static void main(String[] args) {
		FieldExample f1 = new FieldExample();
		f1.name = "이름1";
		f1.age = 20;
		
		FieldExample f2 = new FieldExample();
		f2.name = "이름2";
		f2.age =25;
	}
}
