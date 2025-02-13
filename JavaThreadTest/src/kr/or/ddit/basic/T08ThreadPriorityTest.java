package kr.or.ddit.basic;

import java.util.Iterator;

public class T08ThreadPriorityTest {
	public static void main(String[] args) {
		System.out.println("최대 우선순위 : " + Thread.MAX_PRIORITY);
		System.out.println("최소 우선순위 : " + Thread.MIN_PRIORITY);
		System.out.println("보통 우선순위 : " + Thread.NORM_PRIORITY);
		
		
		Thread[] ths = new Thread[] {
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest1(), new ThreadTest1(),
				new ThreadTest2()
		};
		
		// 우선순위는 start()메서드를 실행하기 전에 설정해야 한다.
		for(int i=0; i<ths.length; i++) {
			if(i==16) {
				ths[i].setPriority(10);
			} else {
				ths[i].setPriority(1);
			}
		}
		
		// 설정된 우선순위 정보 가져오기
		for (Thread th : ths) {
			System.out.println(th.getName() + "의 우선순위 : " + th.getPriority());
		}
		// 스레드 구동시키기
		for (Thread th : ths) {
			th.start();
		}
		
	}
}

// 대문자를 출력하는 스레드
class ThreadTest1 extends Thread {
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);

			// 시간 때우기용...
			for (long i = 1; i <= 1000000000; i++) {
			}
		}
	}
}

//소문자를 출력하는 스레드
class ThreadTest2 extends Thread {
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(ch);

			// 시간 때우기용...
			for (long i = 1; i <= 1000000000; i++) {
			}
		}
	}
}