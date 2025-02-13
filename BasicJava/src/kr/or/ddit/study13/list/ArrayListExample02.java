package kr.or.ddit.study13.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayListExample02 obj = new ArrayListExample02();
		obj.process();

	}

	public void process() {
//		method1();
//		method2();
		method3();
	}

	public void method1() {
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt();

		// num의 약수값을 ArrayList에 담으세요.
//		int cur = 0;
//		for(int i = 0 ; i<=num ; i++) {
//			if(num%i!=0) cur++;
//		}
//		int[] array = new int[cur];
//		for(int i = 1; i<=num;i++) {
//			if(num%i==0) array[cur++] = i;
//		}
		List<Integer> list = new ArrayList();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
//			int n = (int)list.get(i);
		}
	}

	public void method2() {
		// 입력 하는 문자를 list 에 저장하시오.
		List<String> list = new ArrayList();
		while (true) {
			String word = sc.next();
			// end를 입력하면 종료
			if (word.equals("end"))
				break;
			list.add(word);

		}
		// list 출력 해보기
		for (String str : list) {
			System.out.println(str);
		}
	}

	public void method3() {
		List<Member> memberList = new ArrayList();
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원삭제");
			System.out.println("3. 회원 정보수정");
			System.out.println("4. 전체 출력");
			
			int sel = sc.nextInt();
			if(sel==1) {
				Member member = new Member();
				System.out.println("ID : ");
				String id = sc.next();
				
				System.out.println("NAME : ");
				String name = sc.next();
				
				member.setId(id);
				member.setName(name);
				memberList.add(member);
			}
			if(sel==2) {
				for(int i = 0 ; i < memberList.size(); i ++) {
					Member member = memberList.get(i);
					System.out.println(i + ", " + member.getId()+", "+member.getName());
				}
				System.out.println();
				int index = sc.nextInt();
				Member member = memberList.remove(index);
				System.out.println(member.getName()+"님이 탈퇴하셨습니다.");
			}
		
		}
	}
}
