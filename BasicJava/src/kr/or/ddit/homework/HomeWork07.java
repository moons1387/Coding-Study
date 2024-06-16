package kr.or.ddit.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork07 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork07 obj = new HomeWork07();
		obj.process();
	}

	public void process() {
		String[] words = { "deserve", "cart", "he", "jet", "fright", "frustrate", "blossom", "scrub", "choir", "amount",
				"mechanism", "long", "chip", "blink", "too", "chop", "pave", "flavor", "habitat", "neither", "slip",
				"paragraph", "apply", "pad", "role", "from", "peak", "happen", "blonde", "organ", "format", "assess",
				"laugh", "manipulat", "meat", "column", "jar", "undergo", "fan", "through", "tend", "consensus", "quit",
				"oblige", "mood", "resort", "knight", "hat", "broad", "theater", "versus", "against", "via", "quarter",
				"hundred", "decade", "teenage", "billion", "dozen", "century", "dose", "double", "may", "the", "could",
				"should", "would", "dare", "shall", "can", "ought", "bit", "whereas", "criteria", "protein", "notion",
				"without" };

		int ran = new Random().nextInt(words.length);

		String select = words[ran];
		char[] ch = select.toCharArray();
		char[] ch2 = new char[1];
		for (int i = 0; i < 10000000; i++) {
			int ran2 = new Random().nextInt(ch.length);
			ch2[0] = ch[0];
			ch[0] = ch[ran2];
			ch[ran2] = ch2[0];
		}
		String Q = new String(ch);
		System.out.println(Q);
		int cnt = 0;
		while (true) {
			System.out.println("올바른 단어를 입력하세요.");
			String A = sc.next();
			cnt++;
			if (A.equals(select)) {
				break;
			} else {
				continue;
			}
		}
		System.out.println(cnt + "회 시행되었습니다.");
		System.out.println(" 정답입니다.");
	}

}