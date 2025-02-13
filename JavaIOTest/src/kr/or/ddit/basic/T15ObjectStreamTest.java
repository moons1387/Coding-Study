package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 객체 입출력을 위한 보조스트림 예제
 * 
 * @author
 * 
 */
public class T15ObjectStreamTest {
	public static void main(String[] args) throws IOException {
		MemberVo mem1 = new MemberVo("홍길동", 20, "대전");
		MemberVo mem2 = new MemberVo("이순신", 30, "부산");
		MemberVo mem3 = new MemberVo("일지매", 40, "대구");
		MemberVo mem4 = new MemberVo("강감찬", 50, "광주");

		FileOutputStream fos = new FileOutputStream("/Users/jeongmunseong/Test/memObj.bin");
		// 객체 출력을 위한 보조스트림 생성하기
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// 객체 쓰기
		oos.writeObject(mem1);
		oos.writeObject(mem2);
		oos.writeObject(mem3);
		oos.writeObject(mem4);

		oos.close();

		System.out.println("객체 쓰기 작업 완료...");
		
		///////////////////////////////////////////////////////////////////
		
		// 저장된 객체정보를 읽어와 출력하기
		FileInputStream fis = new FileInputStream("/Users/jeongmunseong/Test/memObj.bin");
		
		// 객체 입력처리를 위한 보조스트림 생성하
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = null;
		
		try {
			while((obj = ois.readObject()) != null) {
				// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
				MemberVo mem = (MemberVo) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("읽기 작업 끝...");
		}

	}

}

class MemberVo implements Serializable {
	
	/*
	 * transient => 직렬화가 되지 않을 멤버변수에 지정한다.
	 * 				(static 필드도 직렬화가 되지 않는다.)
	 * 				직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.
	 * 				(참조형 변수 : null, 숫자형 변수 : 0, 논리형 변수 : false)
	 */
		
	private String name;
	transient private int age;
	transient private String addr;

	public MemberVo(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}