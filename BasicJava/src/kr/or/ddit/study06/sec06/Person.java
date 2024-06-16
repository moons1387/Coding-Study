package kr.or.ddit.study06.sec06;

public class Person {
	private String name;
	private int age;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
		if(age<0 || age>122) {
			System.out.println("유효한 나이를 입력해 주세요");
		} else {
			this.age = age;
		}
	}
	public int getAge() {
		return age;
	}
}
