package kr.or.ddit.study06.sec02;

public class FoodExample {
	public static void main(String[] args) {
		// 객체 2개 생성 후 적절한 값을 넣어보세요.

		Food chocolate = new Food();
		Food cookie = new Food();

		chocolate.name = "밀크초콜릿";
		chocolate.year = "2024-03-10";
		chocolate.price = 3000;

		cookie.name = "초코칩쿠키";
		cookie.year = "2024-04-10";
		cookie.price = 2000;

		System.out.println("제품명 : " + chocolate.name + "   생산일 : " + chocolate.year + "   가격 : " + chocolate.price);
		System.out.println("제품명 : " + cookie.name + "   생산일 : " + cookie.year + "   가격 : " + cookie.price);

		System.out.println(chocolate);
		System.out.println(cookie);
	}
}
