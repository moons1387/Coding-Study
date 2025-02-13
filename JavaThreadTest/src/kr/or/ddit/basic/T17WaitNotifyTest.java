package kr.or.ddit.basic;

public class T17WaitNotifyTest {
/*
 * wait() => 동기화 영역에서 락을 풀고 wait-set영역(공유객체별 존재)으로 이동시킨다.
 * 
 * notify() 또는 notifyAll() => wait-set 영역에 있는 스레드를 깨워서 실행할 수 있도록 한다.
 * (notify()는 하나, notifyAll()은 wait-set에 존재하는 모든 스레드를 깨운다.)
 * 
 * => wait()과 notify(), notifyAll()메서드는 동기화 영역에서만 실행할 수 있고,
 * 	  Object 클래스에서 제공되는 메서드이다.
 */
	public static void main(String[] args) {
		
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}
}


// 공유객체용 클래스
class WorkObject {
	
	public synchronized void methodA() {
		System.out.println("methodA() 처리중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void methodB() {
		System.out.println("methodB() 처리중...");
		
		notify();
		
		try {
			wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


// WorkObject의 methodA()메서드만 호출하는 스레드
class ThreadA extends Thread {
	private WorkObject workObj;
		
	public ThreadA(WorkObject workObj) {
		super("ThreadA");
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for(int i = 1 ; i <= 10 ; i ++) {
			workObj.methodA();
		}
		System.out.println("ThreadA 종료...");
	}
}


// WorkObject의 methodA()메서드만 호출하는 스레드
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		super("ThreadB");
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1 ; i <= 10 ; i ++) {
			workObj.methodB();
		}
		System.out.println("ThreadB 종료...");
	}
}