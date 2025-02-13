package kr.or.ddit.basic;

import java.util.Iterator;

public class T01ArgsTest {
	/*
	 * 가변형 인수 => 메서드의 매개변수의 개수가 실행될 때 마다 다를 때 사용한다.
	 * 
	 * 		- 가변형 인수는 메서드 안에서는 배열로 처리된다. 
	 * 		- 가변형 인수는 한가지 자료형만 사용할 수 있다.
	 * 
	 */

	public int sumArr(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	public int sumArgs(int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	// 가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야한다.
	public String sumArgs2(String name, int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name + "씨 점수 : " + sum;
	}

	
	public static void main(String[] args) {
		T01ArgsTest at = new T01ArgsTest();
	
		int[] nums = { 100, 200, 300 };
		System.out.println(at.sumArr(nums));
		System.out.println(at.sumArr(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println();

		System.out.println(at.sumArgs(100, 200, 300));
		System.out.println(at.sumArgs(1, 2, 3, 4, 5));
		System.out.println();

		System.out.println(at.sumArgs2("홍길동", 1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println(at.sumArgs2("asd", 1,1,1));

	}

}
