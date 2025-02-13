package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09FileEncodingTest {
	/* 한글 인코딩 방식에 대하여...
	 * 
	 * 한글 인코딩 방식은 크게 UTF-8 과 EUC-KR 방식 두가지로 나누어 볼 수 있다.
	 * 원래 한글윈도우는 CP949방식을 사용했는데, 
	 * 윈도우를 개발한 마이크로소프트사에서 EUC-KR 방식을 확장하여 만들었기 때문에
	 * MS949라고도 부른다.
	 * 한글 윈도우의 메모장에서 말하는 ANSI 인코딩이란 CP949(Code Page 949)를 말한다.
	 * CP949 는 EUC-KR의 확장이며, 하위 호환성이 있다.
	 * 
	 * - MS949(CP949) => 윈도우의 기본 한글 인코딩방식(ANSI 계열)
	 * - UTF-8 => 유니코드 UTF-8인코딩 방식
	 * - US-ASCII => 영문 전용 인코딩 방식
	 * 
	 * 참고)
	 * ASCII => extended ASCII(ISO 8859-1) => 조합형, 완성형 => 윈도우계열 : CP949(확장완성형) - 일부문자(8822자)추가함
	 * 														 => 유닉스계열 : EUC-KR(확장 유닉스 코드)
	 * 		 => ANSI 계열
	 * 
	 * 		 => 유니코드(UTF-8)
	 */
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("d:/D_Other/test_ansi.txt");
//		FileInputStream fis = new FileInputStream("d:/D_Other/test_utf8.txt");
		
		// 파일 인코딩 정보를 이용하여 읽어오기
		// InputStreamReader를 이용하면 인코딩 방식을 지정하여 읽을 수 있다.
		// new InputStreamReader(바이트기반 스트림객체, 인코딩방식)
//		InputStreamReader isr = new InputStreamReader(fis, "MS949");
		InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
//		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		
		int data = 0;
		
		while((data = isr.read()) != -1) {
			System.out.print((char)data);
		}
		
		fis.close();
		isr.close();
		
		System.out.println();
		System.out.println("출력 끝...");
	}
	
}











