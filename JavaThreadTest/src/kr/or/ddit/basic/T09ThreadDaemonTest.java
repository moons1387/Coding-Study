package kr.or.ddit.basic;

public class T09ThreadDaemonTest {
	public static void main(String[] args) {
		
		AutoSaveThread autoTh = new AutoSaveThread();
		
		// 데몬스레드로 설정하기 (start()실행 전에 설정해야 한다.)
		autoTh.setDaemon(true);
		autoTh.start();
		
		try {
			for(int i = 1 ; i <= 20 ; i ++) {
				System.out.println("작업 - " + i);
				
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("메인 스레드 종료...");
	}
}


/**
 * 자동 저장하는 기능을 제공하기 위한 스레드
 */
class AutoSaveThread extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
	
	private void save() {
		System.out.println("작업 내용을 저장합니다...");
	}
	
}