package kr.or.ddit.study02.sec01;

public class Examplevar03 {

	int c = 10;

	public static void main(String[] args) {
		// int 타입 변수 x, y를 선언하시오
		// x에 2, y에 3 값을 넣으시오.
		// x+y 값을 출력하시오.

		int x = 2, y = 3;

		{
			int a = 10;
			int b = 10;
			{
				System.out.println(a);

			}
		}
		int b = 20;
		System.out.println(b);

		System.out.println(x + y);

//		int x;
//		int y;
//		x=2;
//		y=3;
//		System.out.println(x+y);

//    	int x=2;
//    	int y=3;
//    	System.out.println(x+y);
	}

	public void test() {
		int x = 30;
		System.out.println(c + x);
	}

}
