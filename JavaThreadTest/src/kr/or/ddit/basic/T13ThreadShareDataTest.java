package kr.or.ddit.basic;

public class T13ThreadShareDataTest {

	public static void main(String[] args) {
		ShareData sd = new ShareData(); // 공유객체 생성
		
		CalcPIThread cTh = new CalcPIThread(sd);
		PrintPIThread pth = new PrintPIThread(sd);
		
		cTh.start();
		pth.start();
				
				
	}
}

// 원주율 정보를 관리하기 위한 클래스(공유객체 생성용)
class ShareData {
	private double result; // 원주율이 저장될 변수
	/*
	 *  valotile => 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	 *  			즉, 값이 변경되는 즉시 변수에 적용시킨다.
	 *  			멀티 스레드 환경에서 하나의 변수가 완벽하게 
	 *  			한번에 작동하도록 보장하는 키워드
	 *  			(일종의 동기화)
	 */
	volatile boolean isOk; // 원주율 계산이 완료되었는지 확인하기 위한 변수

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
}

// 원주율을 계산하기 위한 스레드
class CalcPIThread extends Thread {
	private ShareData sd;
	
	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		/*
		 * 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9...)*4;
		 * 			   1 -   3 +   5 -   7 +   9... => 분모
		 * 			   0     1     2     3     4... => 2로 나눈 몫
		 */
		double sum = 0.0;
		for(long i=1; i<150000000; i+=2) {
			if(((i/2)%2)==0) {	// 2로 나눈 몫이 짝수이면 부호가 +
				sum+=(1.0/i);
			} else { // 아니면 부호가 -
				sum-=(1.0/i);
			}
		}
		
		sd.setResult(sum*4);
		sd.setOk(true);
		
	}
}

// 계산된 원주율을 출력하기 위한 스레드
class PrintPIThread extends Thread {
	private ShareData sd;
	
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		while (true) {
			if(sd.isOk()) {
				break;
			}
		}
		System.out.println();
		System.out.println("계산된 원주율 : " + sd.getResult());
		System.out.println("           PI : " + Math.PI);
	}
}