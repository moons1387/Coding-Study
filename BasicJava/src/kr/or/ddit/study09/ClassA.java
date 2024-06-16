package kr.or.ddit.study09;

public class ClassA {
	int a = 10;
	public static void main(String[] args) {
		// ClassA 에 a 값 호출하기
		ClassA classA = new ClassA();
		System.out.println(classA.a);
		// ClassB 에 b 값 호출하기
		ClassB classB = classA.new ClassB();
		System.out.println(classB.b);
		// ClassC 에 c 값 호출하기
//		ClassC classC = new ClassC();
		ClassC classC = new ClassA.ClassC();
		System.out.println(classC.c);
	}
	
	public class ClassB {
		
		int b = 10;
	}
	
	public static class ClassC {
		
		int c = 10;
	}

}
