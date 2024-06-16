package kr.or.ddit.study07.sec02.tell;

public class RoundRobn extends Schedular {
	@Override
	public void getNextCall() {
		System.out.println("상담전화를 대기열에서 차례대로 가져옴");
	}
	@Override
	public void sendCallToAgent() {
		System.out.println("차례대로 상담원에게 상담전화를 분배");
	}
}
