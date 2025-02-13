package kr.or.ddit.basic;

public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("method1이 호출되었습니다.");
	}

	@PrintAnnotation("%")
	public void method2() {
		System.out.println("method2이 호출되었습니다.");
	}

	@PrintAnnotation(value = "#", count = 25)
	public void method3() {
		System.out.println("method3이 호출되었습니다.");
	}
}
