package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class RSP {
	public static boolean IN = false;

	public static void main(String[] args) {
		Thread th1 = new CountDown5();
		th1.start();
//		Thread th2 = new Input();
//		th2.start();
	}
}

class CountDown5 extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if (RSP.IN) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("5초 경과. 패");
		System.exit(0);
	}
}

//class Input extends Thread {
//	@Override
//	public void run() {
//		String str = "";
//		int b = 0;
//		do {
//			str = JOptionPane.showInputDialog("가위 바위 보 중 한가지를 입력하세요.");
//		} while {
//			(str.equals("가위") || str.equals("바위") || str.equals("보"));
//		}
//			
//	}
//
//}

class PlayRSP {
	int rsp = (int) (Math.random() * 3 + 1);
}