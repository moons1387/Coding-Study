package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSortTest {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬 전 : " + list);

		// 정렬은 Collections.sort() 메서드를 이용하여 정렬한다.
		// 정렬은 기본적으로 '오름차순 정렬'을 수행한다.
		Collections.sort(list);

		System.out.println("정렬 후 : " + list);

		Collections.shuffle(list); // 섞기

		System.out.println("섞은 후 : " + list);

		Collections.sort(list, new Desc());

		System.out.println("외부정렬자를 이용한 정렬 후" + list);

	}
}

class Desc implements Comparator<String> {
	/*
	 * compare() 메서드의 반환값을 결정하는 방법 - 오름차순 정렬일 경우 => 앞의 값이 크면 양수, 같으면 0, 작으면 음수를
	 * 반환하도록 한다.
	 */
	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2) * -1;
	}

}