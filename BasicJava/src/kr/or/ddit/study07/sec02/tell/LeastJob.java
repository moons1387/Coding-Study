package kr.or.ddit.study07.sec02.tell;

public class LeastJob extends Schedular {
	@Override
	public void getNextCall() {
		System.out.println("상담전화를 대기열에서 차례대로 가져옴");
	}
	@Override
	public void sendCallToAgent() {
		System.out.println("대기열이 가장 짧은 상담원에게 분배");
	}
}
