package kr.or.ddit.study13.set;

/**
 *  Hash set
 *  - key 로 이루어짐
 *    key 값은 중복을 허용하지 않고 순서가 보장되지 않음.
 *    
 *  Set 타입의 대표 컬렉션
 *  
 *   주요 메소드
 *    .add()			: 값 추가
 *    .remove()			: 값 삭제
 *    .contains()		: 포함 여부
 *    .iterator()		: 전체 출력을 위한 이터레이터
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SetExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SetExample obj = new SetExample();
		obj.process();

	}

	public void process() {
		Set set = new HashSet();
		
		while(set.size()<6) {
			set.add(new Random().nextInt(45)+1);
		}
		
		
//		set.add("가");
//		set.add("가");
//		set.add("가");
//		set.add("나");
//		set.add("다");
//		set.add("라");
//		set.add(1);
//		set.add(2);
//		set.add(5);
//		set.add(10.4);
//
//		set.remove("나");

		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}



