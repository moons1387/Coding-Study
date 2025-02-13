package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T06ThreadTest {
	
	public static boolean INPUT_CHECK = false;
	
	public static void main(String[] args) {

		Thread th1 = new DataInput();
		th1.start();
		Thread th2 = new CountDown();
		th2.start();
		
	}
}

/**
 * 사용자 입력을 처리하는 스레드
 */
class DataInput extends Thread {
	@Override
	public void run() {

		// 입력이 완료되면 정적변수를 true로 변경해 주기
		String str = JOptionPane.showInputDialog("아무거나 입력하세요. : ");
		T06ThreadTest.INPUT_CHECK = true;
		
		System.out.println("입력한 값은 \"" + str + "\" 입니다.");

	}
}

class CountDown extends Thread {
	@Override
	public void run() {

		for (int i = 10; i >= 1; i--) {
			// 사용자 입력이 왼료되었는지 여부를 확인하여 완료된 경우에는 카운트다운을 종료한다.
			if(T06ThreadTest.INPUT_CHECK) {
				return; // run() 메소드를 끝낸다.
			}
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 10초가 경과되었는데도 사용자 입력을 하 않으면 프로그램을 종료시킨다.
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0); // 프로그램을 종료시킨다.
	}
}