package kr.or.ddit.study13.list;

public class ArrayTest {

	// 배열에서 불편한점
	// 1. 크기를 먼저 지정해야한다.
	String[] array;
	int cur;

	public ArrayTest() {
		array = new String[10];
	}

	public ArrayTest(int size) {
		array = new String[size];
	}

	public void add(String str) {
		if (cur == array.length) {
			String[] temp = new String[array.length + 10];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[cur++] = str;
	}

	// 배열 꺼내기
	public String get(int index) {
		return array[index];
	}

	// 실제 값이 들어간 크기
	public int size() {
		return cur;
	}

	public String remove(int index) {
		String result = array[index];
		String[] temp = new String[array.length];
		int add = 0;
		for (int i = 0; i < cur; i++) {
			if (i == index)
				add++;
			temp[i] = array[i + add];

		}
		cur--;
		array = temp;

		return result;
	}

	public boolean contains(String search) {
		for (String s : array) {
			if (s.equals(search))
				return true;
		}
		return false;
	}
}
