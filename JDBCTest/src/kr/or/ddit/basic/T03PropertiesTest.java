package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class T03PropertiesTest {
	public static void main(String[] args) {
		Properties prop = new Properties();
		File file = new File("res/db.properties");
		try {
			FileInputStream fis = new FileInputStream(file);

			prop.load(fis);
			// 파일로부터 properties 정보 읽기 끝...
			///////////////////////////////////////////////////////////////////////
			
			// 읽어온 데이터 출력하기

			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " : " + value);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
