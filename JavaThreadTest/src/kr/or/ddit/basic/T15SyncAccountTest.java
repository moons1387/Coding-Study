package kr.or.ddit.basic;

import java.awt.Image;

public class T15SyncAccountTest {
	public static void main(String[] args) {

		SyncAccount sAcc = new SyncAccount();
		sAcc.deposit(10000);

		BankThread bTh1 = new BankThread(sAcc);
		bTh1.start();
		BankThread bTh2 = new BankThread(sAcc);
		bTh2.start();

	}
}

// 은행의 입출금을 관리하기 위한 클래스
class SyncAccount {
	private int balance; // 잔액

	public int getBalance() {
		return balance;
	}

	// 입금 처리를 수행하기 위한 메서드
	public void deposit(int money) {
		balance += money;
	}

	// 출금을 처리하기 위한 메서드(출금 성공: true, 출금 실패: false)
	// 동기화 영역에서 호출되는 메서드도 동기화 처리를 해 주어야 한다.
	public boolean withdraw(int money) {
		synchronized (this) {

			if (balance >= money) {
				for (int i = 1; i <= 1000000000; i++) {
				}

				balance -= money; // 출금작업...

				System.out.println("메서드 안에서 valance = " + getBalance());

				return true;

			} else {

				return false;
			}

		}

	}

}

// 은행업무를 처리하기 위한 스레드
class BankThread extends Thread {
	private SyncAccount sAcc;

	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}

	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000); // 6천원 인출
		System.out.println("스레드 안에서 result = " + result + ", balance = " + sAcc.getBalance());

	}

}
