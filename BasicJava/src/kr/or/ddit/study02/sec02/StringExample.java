package kr.or.ddit.study02.sec02;

public class StringExample {
	public static void main(String[] args) {
		// 문자와 문자열
		// 문자(char) 		: ''로 묶어서 선언, 한글자로 구성
		// 문자역(String) 	: ""로 묶어서 선언, 복수개의 글자로 구성된 자료(기본타입은 아님)
		
		String name2 = new String("홍길동");
		String name = "홍길동";
		System.out.println(name);
		System.out.println(name2);
		String result1 = name+"\""+name2;
		System.out.println(result1);
		
		// \n  : 개행 문자
		// \r  : 개행 문자
		// \r\n: 개행 문자
	
		// \t  : 탭
		// \\  : 역슬러시 출력
		// \"  : 큰따옴표 출력
		// \'  : 작은따옴표 출력
		
		System.out.println("\""+name+"\""+", "+"\""+name2+"\"");
		// "홍길동", "홍길동"
		
		int a1 = 20;
		int a2 = 24;
		
		// a1과 a2를 이용해서 2024 출력해보기
		String result3 = ""+a1+a2;
		System.out.println(result3);
		System.out.println(""+a1+a2);
		System.out.println(""+(a1+a2));
		System.out.println("a1+a2="+(a1+a2));
	}

}
