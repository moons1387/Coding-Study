package kr.or.ddit.study06.sec02;

/**
 * @author PC-18
 *
 */
public class Food {
	// 제조일자
	String name;
	String year = "2024.02.20";
	int price;
	
	{
		year = "2024.04.01";
		// 덮어쓰기
	}
	
	// alt + shift + s - generate toString()
	@Override
	public String toString() {
		return "Food [name=" + name + ", year=" + year + ", price=" + price + "]";
	}
	
//	@Override
//	public String toString() {
//		return "제조일자 : "+year+", 이름 : "+name+", 가격 : "+price;
//		
//	}
	
	
	
}
