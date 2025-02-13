package kr.or.ddit.study02.sec03;

public class TypeChange3 {
	public static void main(String[] args) {
		String str = "10";
		int num = Integer.parseInt(str); // 문자열을 int타입을 변환
		System.out.println(num + 3);
		// String -> 기본 타입
		
		// String -> byte
		String str1 = "10";
		byte b1 = Byte.parseByte(str1);
		System.out.println("String -> byte "+b1);
		
		// String -> short
		String str2 = "100";
		short s2 = Short.parseShort(str2);
		System.out.println("String -> short "+s2);
		
		//String -> int
		String str3 = "10000";
		Integer.parseInt(str3);
		System.out.println("String -> int "+str3);
		
		//String -> long
		String str4 = "10000";
		long l4 = Long.parseLong(str4);
		System.out.println("String -> long "+l4);
		
		//String -> float
		String str5 = "0.05";
		float f5 = Float.parseFloat(str5);
		System.out.println("String -> float "+f5);
		
		//String -> double
		String str6 = "2.11";
		double d6 = Double.parseDouble(str6);
		System.out.println("String -> double "+d6);
		
		String str7 = "200";
		int i7 = Integer.valueOf(str7);
		System.out.println("valueOf 사용 "+i7);
	}

}
