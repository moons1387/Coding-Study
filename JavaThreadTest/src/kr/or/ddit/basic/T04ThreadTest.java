package kr.or.ddit.basic;

import java.util.Iterator;

public class T04ThreadTest {
	/*
	 * 1 ~ 20억 까지의 합계를 구하는데 걸린 시간 체크하기
	 * 
	 * 단독으로(스레드 1개) 합계를 구하는 경우와 
	 * 여러개의 스레드로 나누어 합계를 구했을 때의 시간을 확인해 보자.
	 */

	public static void main(String[] args) {
		
		// 단독으로 처리할 때...
		SumThread sTh = new SumThread(1, 2000000000L);
		
		long startTime = System.currentTimeMillis();
		sTh.start();
		
		try {
			sTh.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis(); 
		
		System.out.println("단독으로 처리 했을 때의 처리시간 : " + (endTime - startTime) + ("ms"));
		
		System.out.println();
		
		System.out.println("---------------------------------------------------------------------------");
		
		// 여러 쓰레드가 협력해서 처리했을 때...
		SumThread[] sumThs = new SumThread[] {
				new SumThread(        1L, 100000000L),
				new SumThread(100000001L, 200000000L),
				new SumThread(200000001L, 300000000L),
				new SumThread(300000001L, 400000000L),
				new SumThread(400000001L, 500000000L),
				new SumThread(500000001L, 600000000L),
				new SumThread(600000001L, 700000000L),
				new SumThread(700000001L, 800000000L),
				new SumThread(800000001L, 900000000L),
				new SumThread(900000001L, 1000000000L),
				new SumThread(1100000001L, 1200000000L),
				new SumThread(1300000001L, 1400000000L),
				new SumThread(1400000001L, 1500000000L),
				new SumThread(1500000001L, 1600000000L),
				new SumThread(1600000001L, 1700000000L),
				new SumThread(1700000001L, 1800000000L),
				new SumThread(1800000001L, 1900000000L),
				new SumThread(1900000001L, 2000000000L)
		};
		
		startTime = System.currentTimeMillis();
		for (Thread th : sumThs) {
			th.start();
		}
		for(Thread th : sumThs) {
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("협력으로 처리 했을 때의 처리시간 : " + (endTime - startTime) + ("ms"));

		
	}
}

class SumThread extends Thread {

	private long min, max;

	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		long sum = 0;
		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max + " 까지의 합계 : " + sum);
	}

}