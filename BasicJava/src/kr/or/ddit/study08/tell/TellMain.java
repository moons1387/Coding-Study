package kr.or.ddit.study08.tell;

import java.util.Scanner;

public class TellMain {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TellMain obj = new TellMain();
		obj.process();

	}

	public void process() {
		System.out.println("전화 상담의 분배 방식 선택");
		System.out.println("R : RoundRobn");
		System.out.println("L : LeastJob");
		System.out.println("P : PriorityAllocation");
		System.out.println("선택 >>");
		Schedular schedul = null;
		
		String select = sc.next();
		if(select.equalsIgnoreCase("R")) schedul = new RoundRobn();
		if(select.equalsIgnoreCase("L")) schedul = new LeastJob();
		if(select.equalsIgnoreCase("P")) schedul = new PriorityAllocation();
		
		schedul.getNextCall();
		schedul.sendCallToAgent();
		
		
	}
	
}
