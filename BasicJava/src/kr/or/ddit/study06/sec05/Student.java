package kr.or.ddit.study06.sec05;

public class Student {
	static int year = 2023;
	static String roomNo = "306";
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
