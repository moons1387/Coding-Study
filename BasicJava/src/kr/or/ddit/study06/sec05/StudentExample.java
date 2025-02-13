package kr.or.ddit.study06.sec05;

public class StudentExample {
	
	static int a = 10;
	int b = 20;
	
	public static void main(String[] args) {
		Student s1 = new Student("김민강", 20);
		s1.age = 24;
		s1.year ++;
		Student s2 = new Student("서지윤", 20);
		
		System.out.println(Student.year+" "+s1.toString());
		System.out.println(Student.year+" "+s2.toString());
	
		StaticExample se = new StaticExample();
		int a = se.b;
	}
}
