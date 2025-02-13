package kr.or.ddit.basic;

import java.util.function.LongToDoubleFunction;

public class T02GenericClassTest {
	/*
	 * 제너릭 클래스 생성하는 방법
	 * 
	 * class 클래스명<제네릭타입글자> {
	 * 
	 * 제네릭타입글자 변수명; 
	 * 변수 선언에 제너릭타입글자를 사용할 경우 ... 
	 * 제너릭타입글자 메서드명() { ... return 값; }
	 * ... }
	 * 
	 * -- 제너릭타입글자-- 
	 * T => type 
	 * K => key 
	 * V => value 
	 * E => Elements 
	 * (자료구조에 들어가는 원소들을 의미할때 사용됨)
	 */
	public static void main(String[] args) {
		NonGernericClass ng1 = new NonGernericClass();
		NonGernericClass ng2 = new NonGernericClass();
		
		ng1.setVal("가나다라");
		ng2.setVal(100);
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 rtnVal1 : "+rtnVal1);
		
		Integer rtnVal2 = (Integer) ng2.getVal();
		System.out.println("정수형 반환값 rtnVal2 : "+rtnVal2);
				
		////////////////////////////////////////////////////////
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		rtnVal2 = mg2.getVal();
		
		System.out.println("제너릭 문자열 반환값 : "+rtnVal1);
		System.out.println("제너릭 정수형 반환값 : "+rtnVal2);
		
		
	}
	
	
}




class NonGernericClass {
	private Object val;


	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T> {
	private T val;


	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

}