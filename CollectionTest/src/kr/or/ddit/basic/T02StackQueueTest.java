package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Stack;

public class T02StackQueueTest {
	public static void main(String[] args) {
		
		LinkedList<String> stack = new LinkedList<String>();
		
		/*
		 * stack 명령
		 * 1) 데이터 추가	 : push(저장할 값)
		 * 2) 데이터 꺼내기  : pop() => 데이터를 꺼내온 후 꺼내온 데이터를 stack에서 제거한다.
		 * 
		 */
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		System.out.println("현재 stack값들 : "+stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 데이터 : "+data);
		System.out.println("꺼내온 데이터 : "+stack.pop());
		System.out.println();
		
		System.out.println("현재 stack 값들 : "+stack);
		stack.push("성춘향");
		System.out.println("현재 stack 값들 : " + stack);
		
		System.out.println("==========================================");
		
		LinkedList<String> queue = new LinkedList<String>();
		/*
		 * Queue 방식 처리를 위한 명령
		 * 1) 데이터 추가 	: offer(저장할 값)
		 * 2) 데이터 꺼내기 : poll() => 데이터를 Queue에서 꺼내온 후 Queue에서 삭제한다.
		 */
		
		queue.offer("홍길동");
		queue.offer("변학도");
		queue.offer("일지매");
		queue.offer("강감찬");
		
		System.out.println("현재 queue의 값 : "+queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 데이터 : "+temp);
		System.out.println("꺼내온 데이터 : "+queue.poll());
		System.out.println("현제 queue의 값 : "+queue);
	
		if(queue.offer("성춘향")) {
			System.out.println("신규 등록 데이터 : 성춘향");
			
		}
		
		System.out.println("현재 queue의 값 : "+queue);
		System.out.println("꺼내온 데이터 : "+ queue.poll());
	
	}
	
	
}
