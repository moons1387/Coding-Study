package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class T05HashSetTest {
	public static void main(String[] args) {

		Set hs1 = new HashSet();
		// Set에 데이터를 추가할 때에도 add()메서드를 이용한다.

		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);

		System.out.println("Set 데이터 : " + hs1);
		System.out.println();

		// Set은 데이터의 인덱스 개념을 사용하지 않고, 중복을 허용하지 않는다.
		// 그래서 이미 존재하는 데이터를 add하면 false를 반환하고, 데이터는 추가되지 않는다.

		boolean isAdded = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdded);
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();

		isAdded = hs1.add("CC");
		System.out.println("중복될 때 : " + isAdded);
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();

		// Set은 데이터를 수정하는 방법을 따로 제공하지 않기 때문에 해당 데이터를 삭제한 후
		// 새로운 데이터를 추가해 주어야 한다.

		// 삭제하는 메서드
		// 1. .clear() => Set 데이터 전체 삭제
		// 2. .remove(삭제할 데이터) => 해당 데이터 삭제

		// ex) 'FF'를 'EE'로 수정하기
		hs1.remove("FF");
		System.out.println("FF 삭제 후 Set 데이터 : " + hs1);
		System.out.println();

		hs1.add("EE");
		System.out.println("EE를 추가 후 Set 데이터" + hs1);
		System.out.println("Set의 데이터 개 수 :" + hs1.size());
		System.out.println();

		// Set은 인덱스 개념을 사용하지 않기 때문에 List처럼 인덱스를 하나씩 가져올 수 없다.
		// 그래서 데이터를 하나씩 접근하기 위한 Iterator 객체를 사용한다.

		Iterator it = hs1.iterator();

		while (it.hasNext()) { // it.hasNext() => 다음에 가져올 데이터가 있다면 true, 없다면 false를 반환
			// it.next() => 다음 데이터를 가져옴
			System.out.print(it.next() + " ");
		}

		// 1 ~ 100 사이의 중복되지 않는 정수 5개 만들기

		Set<Integer> intRnd = new HashSet<Integer>();

		while (intRnd.size() < 5) {
			int num = (int) (Math.random() * 100 + 1);
			intRnd.add(num);
		}
		System.out.println("만들어진 난수들 : " + intRnd);

		// Collection 유형의 객체들은 서로 다른 자료구조로 쉽게 변경해서 사용할 수 있다.
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);
		System.out.println();
		for (Integer integer : intRndList) {
			System.out.print(integer + " ");
		}

	}
}
