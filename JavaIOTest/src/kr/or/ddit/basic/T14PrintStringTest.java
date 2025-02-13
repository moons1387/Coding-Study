package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class T14PrintStringTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("/Users/jeongmunseong/Test/print.txt");
		// PrintStream은 모든 자료형(데이터)를 출력할 수 있는 기능을 제공하는 OutputStream의 서브클래스이다.
		PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.println("안녕하세요. PrintStream 입니다.2");
		out.println("안녕하세요. PrintStream 입니다.3");
		out.println(out);  // 객체 출력
		out.println(3.14); // double 데이터 출력
		
		out.close();
		
		////////////////////////////////////////////////////////////////////////////////
		
		/*
		 * PrintWriter는 데이터를 문자로 출력하는 기능을 제공한다.
		 * PrintStream보다 향상된 기능을 제공하지만 계속 PrintStream이 사용되고 있음.
		 * PrintWriter는 다양한 인코딩 처리를 하는데 적합하다.
		 */
		
		
		FileOutputStream fos2 = new FileOutputStream("/Users/jeongmunseong/Test/print.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos2, "CP949");
		PrintWriter pw = new PrintWriter(fos2);
		
		pw.print("안녕하세요. PrintWriter 입니다.\n");
		pw.println("안녕하세요. PrintWriter 입니다.2");
		pw.println("안녕하세요. PrintWriter 입니다.3");
		pw.println(pw);   //객체 출
		pw.println(3.14); // double 데이터 출
		
	}
}
