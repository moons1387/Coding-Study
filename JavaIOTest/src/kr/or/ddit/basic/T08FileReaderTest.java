package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class T08FileReaderTest {
	public static void main(String[] args) throws IOException {
		
		// 문자기반 스트림 객체를 이용한 파일내용 읽기...
		FileReader fr = new FileReader("d:/D_Other/testChar.txt");
		
		int data = 0;
		
		while((data = fr.read()) != -1) {
			System.out.print((char)data);
		}
		
		fr.close();
		
	}
}
