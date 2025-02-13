package kr.or.ddit.basic.homework;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeWork06 {
	public static void main(String[] args) {
		HomeWork06 h = new HomeWork06();
		
		long time1 = System.currentTimeMillis();
		
		h.copy1();
			
		long time2 = System.currentTimeMillis();
		
		h.copy2();
		
		long time3 = System.currentTimeMillis();
		
		System.out.println("버퍼없는 복사 : "+(time2 - time1)+"ms");
		System.out.println("버퍼있는 복사 : "+(time3 - time2)+"ms");
		
	}
	
	public void copy1() {
		
		FileInputStream fis;
		FileOutputStream fos;
		
		try {
			
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			
			int data = 0;

			fos = new FileOutputStream("d:/D_Other/Tulips.사본.jpg");

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void copy2() {
		
		File f1 = new File("d:/D_Other/Tulips.jpg");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(f1);
			int data = 0;
			
			fos = new FileOutputStream("d:/D_Other/Tulips.사본.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			while((data = fis.read())!=-1) {
				bos.write(data);
			}
			
			bos.flush();
			fis.close();
			fos.close();
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
