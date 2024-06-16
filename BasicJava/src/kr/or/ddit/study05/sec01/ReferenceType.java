package kr.or.ddit.study05.sec01;

import java.util.Scanner;

public class ReferenceType {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ReferenceType obj = new ReferenceType();
		obj.process();

	}

	public void process() {
		int a = 10;
		int b = 11;
		String c = "abc";
		String d = "abc";
		method1();
	}
	public void method1() {
			String a = "홍길동";
			String b = "홍길동";
			String c = new String("홍길동");
			String d = new String("강감찬");
			String e = new String("강감찬");
			// c 홍길동은 a, b 와 다른 주소를 가지고 있음
			// d 와 e 는 각각 다른 주소를 가지고 있음
			
			System.out.println(a==b);
			System.out.println(a==c);
			System.out.println(c==d);
			System.out.println(d==e);
			
			// String 주소값이 아닌 힙영역의 값을 비교
			System.out.println(b.equals(c));
			
		}
}
