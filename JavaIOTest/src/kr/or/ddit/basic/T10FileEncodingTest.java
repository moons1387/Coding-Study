package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T10FileEncodingTest {
	public static void main(String[] args) throws IOException {
		/* OutputSreamWriter => 바이트 기반 스트림 객체를 문자기반 스트림 객체로 변환해 주는 보조스트림.
		 * 					 => 이 스트림 객체도 '인코딩 방식'을 지정하여 출력할 수 있다. 
		 */
		
		// 키보드로 입력한 내용을 파일로 저장하는데 
		// out_utf8.txt 파일은 'UTF-8' 인코딩 방식으로,
		// out_ansi.txt. 파일은 'MS949' 인코딩 방식으로 저장해 보자.
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		// 파일 출력용 객체 생성
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
		
		// 보조스트림 객체 생성
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "MS949");
		
		System.out.println("아무거나 입력하세요");
		
		int data = 0;
		
		while ((data = isr.read()) != -1) {
			osw1.write(data);
			osw2.write(data);
			
		}
		System.out.println("파일 출력 작업 완료...");
		
		isr.close();
		osw1.close(); // 보조스트림만 닫아도 된다.
		osw2.close(); // 보조스트림만 닫아도 된다.
		
	}
}
