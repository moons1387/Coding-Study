package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.naming.directory.AttributeModificationException;

public class T04ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		byte[] temp = new byte[4];

		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int readedBytes = 0;

		while ((readedBytes = bais.read(temp)) != -1) {

			System.out.println("temp => " + Arrays.toString(temp));

			baos.write(temp, 0, readedBytes);
		}

		outSrc = baos.toByteArray();

		System.out.println("스트림 클래스 사용 outSrc => " + Arrays.toString(outSrc));
	}
}
