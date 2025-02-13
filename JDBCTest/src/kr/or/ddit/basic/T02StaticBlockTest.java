package kr.or.ddit.basic;

public class T02StaticBlockTest {
	public T02StaticBlockTest() {
		System.out.println("생성자 호출됨.");
	}
	static {
		System.out.println("첫번째 static block 호출됨");
	}
	
	static {
		System.out.println("두번째 static block 호출됨");
	}
	
	{
		System.out.println("첫번째 instance block 호출됨");
	}
	
	{
		System.out.println("두번째 instance block 호출됨");
	}
	
	public static void main(String[] args) {
		
		new T02StaticBlockTest();
		
		new T02StaticBlockTest();
		
	}
}
