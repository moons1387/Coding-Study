package kr.or.ddit.basic;

/**
 * 제한된 타입 파라미터 예제
 * 
 * @author 정문성
 */
public class T04BoundedParameterTest {
	public static void main(String[] args) {
		int result = Util2.compare(10, 20);
		System.out.println(result);
		
		result = Util2.compare(3.14, 3);
		System.out.println(result);
		
//		result = Util2.compare("dd", 3);
		
	}
}

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {

		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return Double.compare(v1, v2);
	}
}